package Persistencia;

import Persistencia.Clases.CatalogoGeneral;
import Persistencia.Clases.CatalogoXProveedor;
import Persistencia.Clases.CompraItem;
import Persistencia.Clases.CompraItemAProveedorDefault;
import Persistencia.Clases.CompraItemAProveedorX;
import Persistencia.Clases.HistorialGeneral;
import Persistencia.Clases.HistorialXProveedor;
import Persistencia.Clases.Item;
import Persistencia.Clases.ItemDeProveedorX;
import Persistencia.Clases.ItemDeSTOCK;
import Persistencia.Clases.Proveedor;
import Persistencia.Clases.Stock;
import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTItemDeSTOCK;
import Persistencia.DTOs.DTProveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Santi-kun
 */
public class ManejadorDePersistencia {
    

    private ManejadorDePersistencia(){}
    //Instancia única al usar static
    private static ManejadorDePersistencia instancia = null;
    
    public static ManejadorDePersistencia getInstancia() {
        if (instancia == null) {
            instancia = new ManejadorDePersistencia();
        }
        return instancia;
    
    }
    
     public void persistirItem(Item nuevoItem){    
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            // 1) Busco el catálogo general existente (hay 1 solo)
        CatalogoGeneral cat = em.createQuery("SELECT c FROM CatalogoGeneral c WHERE c.clave = :clave",
                CatalogoGeneral.class)
                .setParameter("clave", "DEFAULT")
                .getResultStream()
                .findFirst()
                .orElse(null);
            // 2) Si no existe, lo creo y persisto
            if (cat == null) {
                cat = new CatalogoGeneral();
                em.persist(cat);
            }
            // 3) Lo asigno al item (porque es NOT NULL la realacion)
            nuevoItem.setCatalogo(cat);
            // 4) Persisto el item
            em.persist(nuevoItem);
            et.commit();
        }
        catch(Exception e) {if (et.isActive()) {et.rollback();}throw new PersistenceException("Error al persistir item", e);} 
            finally {em.close();}
    }
    
    
   public void persistirProveedor(Proveedor nuevoProveedor){    
    EntityManager em = FabricaEntityManager.getEntityManager();
    EntityTransaction et = em.getTransaction();
    try{
        et.begin();

        // asegurás que exista catálogo y estén linkeados ambos lados
        nuevoProveedor.asegurarCatalogo();

        // con cascade ALL, esto persiste proveedor + catálogo
        em.persist(nuevoProveedor);

        et.commit();
    } catch(Exception e) {
        if (et.isActive()) et.rollback();
        throw new PersistenceException("Error al persistir proveedor", e);
    } finally {
        em.close();
    }
}
    
    public Proveedor getOrCreateProveedorDefault() {
    EntityManager em = FabricaEntityManager.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        Proveedor p = em.createQuery(
            "SELECT p FROM Proveedor p WHERE p.nombre = :n",
            Proveedor.class
        ).setParameter("n", "DEFAULT")
         .getResultStream()
         .findFirst()
         .orElse(null);

        if (p == null) {
            p = new Proveedor(
                "DEFAULT",
                "-", "-", 
                "Seleccione este proveedor cuando no quiera especificar dónde lo compró",
                "/Imagenes/UsuarioDefault.png"
            );

            // IMPORTANTÍSIMO: crearle catálogo (por nullable=false)
            p.asegurarCatalogo();

            em.persist(p);
        } else {
            // si existía de antes (o de una DB vieja) y quedó sin catálogo, lo arreglás
            if (p.getCatalogo() == null) {
                p.asegurarCatalogo();
                // como p ya es managed, con commit alcanza
            } else if (p.getCatalogo().getProveedor() == null) {
                p.getCatalogo().setProveedor(p);
            }
        }

        tx.commit();
        return p;
    } catch (Exception e) {
        if (tx.isActive()) tx.rollback();
        throw e;
    } finally {
        em.close();
    }
}
    
    
    public List<Item> getItemsDeCatalogoGeneral(EntityManager em) {
    CatalogoGeneral c = em.find(CatalogoGeneral.class, "DEFAULT");
    if (c == null) return List.of(); // o new ArrayList<>()
    return c.getItemsDeCatalogo();
}
    
    public List<Item> getItemsDeCatalogoGeneralOptimizado() {
    EntityManager em = FabricaEntityManager.getEntityManager();
    try {
        return em.createQuery(
            "SELECT i FROM Item i WHERE i.catalogo.clave = :id ORDER BY i.id",
            Item.class
        )
        .setParameter("id", "DEFAULT")
        .getResultList();
    } finally {
        em.close();
    }
}
    
  public List<Proveedor> obtenerTodosLosProveedoresOrderByNombre(EntityManager em) {
    return em.createQuery(
            "SELECT p FROM Proveedor p ORDER BY p.nombre",
            Proveedor.class
    ).getResultList();
}
  
  public List<Proveedor> obtenerTodosLosProveedoresOrderById(EntityManager em) {
    return em.createQuery(
            "SELECT p FROM Proveedor p ORDER BY p.id",
            Proveedor.class
    ).getResultList();
}
 /*   
    public void persistirCatalogoGeneral(CatalogoGeneral nuevoCatGeneral){    
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(nuevoCatGeneral);
            et.commit();
            }
        catch(Exception e) {
            if (et.isActive()) et.rollback();
            throw new PersistenceException("Error al persistir Catalogo General", e);
                } 
            finally {em.close();}
    }


*/
public Proveedor getProveedorAPartirDeId(Long proveedorId) {
    EntityManager em = FabricaEntityManager.getEntityManager();
    try {
        return em.find(Proveedor.class, proveedorId);
    } finally {
        em.close();
    }
}

public DTItem getDTItem(EntityManager em, Long itemId) {
    Item it = em.createQuery(
        "SELECT DISTINCT it FROM Item it " +
        "WHERE it.id = :id",
        Item.class
    )
    .setParameter("id", itemId)
    .getSingleResult();
    
    DTItem dt = it.crearDTItem();
    return dt;
}

public DTItemDeSTOCK getDTItemDeSTOCK(EntityManager em, Long itemId) {
    ItemDeSTOCK it = em.createQuery(
        "SELECT DISTINCT it FROM ItemDeSTOCK it " +
        "WHERE it.id = :id",
        ItemDeSTOCK.class
    )
    .setParameter("id", itemId)
    .getSingleResult();
    
    DTItemDeSTOCK dt = it.crearDTItemDeSTOCK();
    return dt;
}


//------> AUMENTAR STOCK <-------- 
    public void AumentarStock(ItemDeSTOCK nuevoItemDeStock){    
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            // 1) Busco el catálogo general existente (hay 1 solo)
            List<Stock> listaStocks = em.createQuery("SELECT s FROM Stock s LEFT JOIN FETCH s.itemsDeStock", 
                Stock.class)
                .setMaxResults(1)
                .getResultList();
        
            Stock stock;
            if (listaStocks.isEmpty()){
                stock = null;
            }
            else{
                stock = listaStocks.get(0);
            }
            //La expresion de arriba es equivalente a esta:
            //Stock stock = listaStocks.isEmpty() ? null : listaStocks.get(0);
            // Si no existe, lo creo y persisto
            if (stock == null) {
                stock = new Stock();
                em.persist(stock);
            }
            boolean yaExiste = false;
            //Obtengo la lista de items de stock para revisarla
            List<ItemDeSTOCK> itemsDeStock = stock.getItemsDeSTOCK();
            for (ItemDeSTOCK it: itemsDeStock){
            if(nuevoItemDeStock.getNombre().equals(it.getNombre())){  //ACA PODRIA VER SI TAMBIEN TIENE QUE SER IGUAL LA DESCRIPCION O CON QUE LE NOMBRE LO SEA YA NO LO PERSISTO
                //Si ya existe lo pongo en true para que no entre al otro if y le aumento el stock sin crear un ItemDeSTOCK nuevo
                yaExiste = true;
                it.aumentarStock(nuevoItemDeStock.getCantUnidades());
                }
            }
            //Si luego de salir del for nunca entre a que son iguales es porque no existe asi que lo persisto,  sino se aumenta
            if (yaExiste == false){
                nuevoItemDeStock.setStock(stock);
                em.persist(nuevoItemDeStock);      
            }
            et.commit();
        }
        catch(Exception e) {if (et.isActive()) {et.rollback();}throw new PersistenceException("Error al persistir item de Stock", e);} 
            finally {em.close();}
    }
//------> AUMENTAR STOCK <--------   
//------> DISMINUIR STOCK <--------
 public void DisminuirStock(ItemDeSTOCK ItemAReducir, Integer cantUnidades){    
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            // 1) Busco el catálogo general existente (hay 1 solo)
            Stock stock = em.createQuery("SELECT s FROM Stock s LEFT JOIN FETCH s.itemsDeStock WHERE s.clave = :clave", 
                Stock.class)
                .setParameter("clave", "DEFAULT")
                .getSingleResult();
         
            boolean yaExiste = false;
            //Obtengo la lista de items de stock para revisarla
            List<ItemDeSTOCK> itemsDeStock = stock.getItemsDeSTOCK();
            for (ItemDeSTOCK it: itemsDeStock){
            if(ItemAReducir.getId().equals(it.getId())){  //ACA PODRIA VER SI TAMBIEN TIENE QUE SER IGUAL LA DESCRIPCION O CON QUE LE NOMBRE LO SEA YA NO LO PERSISTO
                //Si ya existe lo pongo en true para que no entre al otro if y le aumento el stock sin crear un ItemDeSTOCK nuevo
                yaExiste = true;
                it.reducirStock(cantUnidades);
                break;
                }
            }
            if (!yaExiste) {
                throw new IllegalArgumentException("El item no existe en el stock: " + ItemAReducir.getNombre());
            }
             et.commit(); // <-- acá se persiste el UPDATE
    } catch (Exception e) {
        if (et.isActive()) et.rollback(); throw new PersistenceException("Error al disminuir stock", e);
    } finally {
        em.close();
    }
    } 
//------> DISMINUIR STOCK <--------
    
 
 
 
 
    public List<ItemDeSTOCK> getItemsDeStock(EntityManager em) {
    Stock s = em.createQuery(
        "SELECT DISTINCT s FROM Stock s " +
        //el left join es para que me traiga ya cargala la lista de items
        "LEFT JOIN FETCH s.itemsDeStock " +
        "WHERE s.id = :id",
        Stock.class
    )
    .setParameter("id", 1L) //Hay un solo stock y lo seteo en 1L
    .getSingleResult();
    
    //una ves traje el catalogo de la base de datos le pido la lista de items
    return s.getItemsDeSTOCK();
    }
    
    public DTProveedor getDTProveedor(EntityManager em, Long proveedorId) {
    Proveedor p = em.createQuery(
        "SELECT DISTINCT p FROM Proveedor p " +
        "WHERE p.id = :id",
        Proveedor.class
    )
    .setParameter("id", proveedorId)
    .getSingleResult();
    
    DTProveedor dt = p.crearDTProveedor();
    return dt;
}
    
    



    public Item getItemAPartirDeId(Long itemId){
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            Item it = em.createQuery(
                    "SELECT DISTINCT it FROM Item it WHERE it.id = :id"
                    ,Item.class)
                    .setParameter("id", itemId)
                    .getSingleResult();
            return it;
        }catch(Exception e) {if (et.isActive()) {et.rollback();}throw new PersistenceException("Error al devolver item", e);} 
            finally {em.close();}  
    }
    
    public ItemDeSTOCK getItemDeSTOCKAPartirDeId(Long itemId){
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            ItemDeSTOCK it = em.createQuery(
                    "SELECT DISTINCT it FROM ItemDeSTOCK it WHERE it.id = :id"
                    ,ItemDeSTOCK.class)
                    .setParameter("id", itemId)
                    .getSingleResult();
            return it;
        }catch(Exception e) {if (et.isActive()) {et.rollback();}throw new PersistenceException("Error al devolver item", e);} 
            finally {em.close();}  
    }
    
 /*   
    public void persistirCompraDefault(CompraItemAProveedorDefault compraDefault, Long proveedorId){    
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            
            Proveedor p = em.find(Proveedor.class, proveedorId);
            //El historial General es unico para todos y lo comparten
        HistorialGeneral histG = em.createQuery(
                "SELECT h FROM HistorialGeneral h",
                HistorialGeneral.class)
                .setMaxResults(1)
                .getResultStream()
                .findFirst()
                .orElse(null);
            // Si no existe, lo creo y persisto
            if (histG == null) {
                histG = new HistorialGeneral();
                histG.addCompra(compraDefault);
                em.persist(histG);
            }
            histG.addCompra(compraDefault);
            //El historialXProveedor es uno para cada Proveedor, en este paso el default
        HistorialXProveedor histP = em.createQuery(
                "SELECT hp FROM HistorialXProveedor hp WHERE hp.id = :id",
                HistorialXProveedor.class)
                .setParameter("id", p.getHistorialXProveedorId()) //Seteo para que busque el historialXProveedor del proveedorDefalut
                .setMaxResults(1)
                .getResultStream()
                .findFirst()
                .orElse(null);
            // Si no existe, lo creo y persisto
            if (histP == null) {
                histP = new HistorialXProveedor();
                em.persist(histP);
            }
            histP.addCompra(compraDefault);
            //LE ASIGNO A LA COMPRA EL HISTORIAL AL QUE CORRESPONDE
            compraDefault.setHistorialGeneral(histG);
            compraDefault.setHistorialXProveedor(histP);
            //PERSISTO LA COMPRA
            em.persist(compraDefault);
            et.commit();
        }
        catch(Exception e) {if (et.isActive()) {et.rollback();}throw new PersistenceException("Error al persistir item", e);} 
            finally {em.close();}
    }
    */
    public void persistirCompra(CompraItem compra, Long proveedorId){    
    EntityManager em = FabricaEntityManager.getEntityManager();
    EntityTransaction et = em.getTransaction();

    try{
        et.begin();

        Proveedor p = em.find(Proveedor.class, proveedorId);

        HistorialGeneral histG = em.find(HistorialGeneral.class, "GENERAL");
        if (histG == null) {
            histG = new HistorialGeneral();
            em.persist(histG);
        }

        HistorialXProveedor histP = em.createQuery(
                "SELECT hp FROM HistorialXProveedor hp WHERE hp.proveedorVinculado.id = :pid",
                HistorialXProveedor.class)
            .setParameter("pid", proveedorId)
            .setMaxResults(1)
            .getResultStream()
            .findFirst()
            .orElse(null);

        if (histP == null) {
            histP = new HistorialXProveedor();
            histP.setProveedor(p);
            em.persist(histP);
        } else {
            histP.setProveedor(p);
        }

        // seteo dueño de relaciones primero
        compra.setHistorialXProveedor(histP);

        // helper que también setea compra.historialGeneral
        histG.addCompra(compra);
        histP.addCompra(compra); // asegurate que haga backref también

        em.persist(compra);

        et.commit();
    } catch(Exception e) {
        if (et.isActive()) et.rollback();
        throw new PersistenceException("Error al persistir compra", e);
    } finally {
        em.close();
    }
}
    
    public List<CompraItem> getTodasLasCompras(HistorialGeneral historial){
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
    try {
        HistorialGeneral h = em.createQuery(
            "SELECT DISTINCT h FROM HistorialGeneral h LEFT JOIN FETCH h.compras ORDER BY h.id",
            HistorialGeneral.class
        )
        .getResultStream()
        .findFirst()
        .orElse(null);
        if (h == null) return Collections.emptyList();
        return h.getCompras();
    } catch(Exception e) {if (et.isActive()) {et.rollback();}throw new PersistenceException("Error al persistir item", e);} 
            finally {em.close();}
        
        
    }
    
    
    public List<CompraItem> getTodasLasCompras() {
    EntityManager em = FabricaEntityManager.getEntityManager();
    try {
        HistorialGeneral h = em.createQuery(
            "SELECT DISTINCT h FROM HistorialGeneral h LEFT JOIN FETCH h.compras",
            HistorialGeneral.class
        )
        .getResultStream()
        .findFirst()
        .orElse(null);

        if (h == null) return java.util.Collections.emptyList();

        return h.getCompras();
    } catch (Exception e) {
        throw new PersistenceException("Error al obtener compras", e);
    } finally {
        em.close();
    }
}
    
    
    public List<CompraItem> getComprasProveedorX(Long proveedorId) {
    EntityManager em = FabricaEntityManager.getEntityManager();
    try {
        HistorialXProveedor h = em.createQuery(
            "SELECT DISTINCT h FROM HistorialXProveedor h LEFT JOIN FETCH h.compras WHERE h.proveedorVinculado.id = :id",
            HistorialXProveedor.class
        )
        .setParameter("id", proveedorId)
        .getResultStream()
        .findFirst()
        .orElse(null);

        if (h == null) return java.util.Collections.emptyList();

    return new java.util.ArrayList<>(h.getCompras()); //Devulevo así para que no puedan modificarla
    } catch (Exception e) {
        throw new PersistenceException("Error al obtener compras", e);
    } finally {
        em.close();
    }
}
    
private CatalogoXProveedor getOrCreateCatalogoXProveedor(EntityManager em, Long proveedorId) {
    CatalogoXProveedor cat = em.createQuery(
        "SELECT p.catalogo FROM Proveedor p WHERE p.id = :pid",
        CatalogoXProveedor.class
    )
    .setParameter("pid", proveedorId)
    .getResultStream()
    .findFirst()
    .orElse(null);

    if (cat == null) {
        Proveedor provRef = em.getReference(Proveedor.class, proveedorId);

        cat = new CatalogoXProveedor();
        provRef.setCatalogo(cat);   
        em.flush(); //fuerza insert/update ya
    }
    return cat;
}

public ItemDeProveedorX getOrCreateItemDeProveedorX(ItemDeProveedorX itemPersistirODevolver) {
    EntityManager em = FabricaEntityManager.getEntityManager();
    EntityTransaction et = em.getTransaction();

    try {
        et.begin();

        Long proveedorId = itemPersistirODevolver.getProveedor().getId();
        Long itemId      = itemPersistirODevolver.getItem().getId();

        ItemDeProveedorX item = em.createQuery(
                "SELECT ip FROM ItemDeProveedorX ip " +
                "WHERE ip.proveedor.id = :pid AND ip.item.id = :iid",
                ItemDeProveedorX.class
        )
        .setParameter("pid", proveedorId)
        .setParameter("iid", itemId)
        .setMaxResults(1)
        .getResultStream()
        .findFirst()
        .orElse(null);

        if (item != null) {
            item.setPrecioItem(itemPersistirODevolver.getPrecioItem());
            item.setCostoFlete(itemPersistirODevolver.getCostoFlete());
            item.setCostoTotal(itemPersistirODevolver.getCostoTotal());
            item.setTiempoDeEnvio(itemPersistirODevolver.getTiempoDeEnvio());
            et.commit();
            return item;
        }
        Item itemRef      = em.getReference(Item.class, itemId);
        itemPersistirODevolver.setItem(itemRef);

        // CLAVE: catálogo correcto del proveedor
        CatalogoXProveedor cat = getOrCreateCatalogoXProveedor(em, proveedorId);
        itemPersistirODevolver.setCatXProv(cat); // <-- ESTO TE FALTABA (y que sea MANAGED)

        em.persist(itemPersistirODevolver);

        et.commit();
        return itemPersistirODevolver;

    } catch (Exception e) {
        if (et.isActive()) et.rollback();
        throw new jakarta.persistence.PersistenceException("Error en getOrCreateItemDeProveedorX", e);
    } finally {
        em.close();
    }
}

public List<ItemDeProveedorX> getListaItemsProveedorXAPartirDeId(Long proveedorId){
    EntityManager em = FabricaEntityManager.getEntityManager();
    try {
        return em.createQuery(
            "SELECT it FROM ItemDeProveedorX it WHERE it.proveedor.id = :id ORDER BY it.id",
            ItemDeProveedorX.class
        )
        .setParameter("id", proveedorId)
        .getResultList();
    } finally {
        em.close();
    }
}



public void editarAlertas(Long itemId, Integer umbralAmarillo, Integer umbralRojo) {
    EntityManager em = FabricaEntityManager.getEntityManager();
    EntityTransaction et = em.getTransaction();

    try {
        et.begin();
        ItemDeSTOCK item = em.find(ItemDeSTOCK.class, itemId);
        if (item == null) {
            throw new PersistenceException("No existe ItemDeSTOCK con id=" + itemId);
        }
        // Validaciones
        if (umbralAmarillo == null || umbralRojo == null) {
            throw new PersistenceException("Los umbrales no pueden ser null");
        }
        if (umbralAmarillo < 0 || umbralRojo < 0) {
            throw new PersistenceException("Los umbrales no pueden ser negativos");
        }
        // Ejemplo de regla: rojo <= amarillo
        if (umbralRojo > umbralAmarillo) {
            throw new PersistenceException("umbralRojo no puede ser mayor que umbralAmarillo");
        }
        item.setUmbralAmarillo(umbralAmarillo);
        item.setUmbralRojo(umbralRojo);

        // No hace falta persist/merge si item está managed
        et.commit();

    } catch (Exception e) {
        if (et.isActive()) et.rollback();
        throw new PersistenceException("Error al editar alertas", e);
    } finally {
        em.close();
    }
}

public void desactivarItem(Long itemId) {
    EntityManager em = FabricaEntityManager.getEntityManager();
    EntityTransaction et = em.getTransaction();
    try {
        et.begin();

        Item item = em.find(Item.class, itemId);
        if (item == null) throw new IllegalArgumentException("Item no existe");

        item.setActivo(false);
        em.merge(item);

        et.commit();
    } catch (Exception e) {
        if (et.isActive()) et.rollback();
        throw new PersistenceException("Error al desactivar item", e);
    } finally {
        em.close();
    }
}

}


    

