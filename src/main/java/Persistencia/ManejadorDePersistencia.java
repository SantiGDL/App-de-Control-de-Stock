package Persistencia;

import Persistencia.Clases.CatalogoGeneral;
import Persistencia.Clases.Item;
import Persistencia.Clases.ItemDeSTOCK;
import Persistencia.Clases.Proveedor;
import Persistencia.Clases.Stock;
import Persistencia.DTOs.DTItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
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
        CatalogoGeneral cat = em.createQuery("SELECT c FROM CatalogoGeneral c", CatalogoGeneral.class).setMaxResults(1).getResultStream().findFirst().orElse(null);
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
            // 4) Persisto el item
            em.persist(nuevoProveedor);
            et.commit();
        }
        catch(Exception e) {if (et.isActive()) {et.rollback();}throw new PersistenceException("Error al persistir proveedor", e);} 
            finally {em.close();}
    }
    
    
    public List<Item> getItemsDeCatalogoGeneral(EntityManager em) {
    CatalogoGeneral c = em.createQuery(
        "SELECT DISTINCT c FROM CatalogoGeneral c " +
        //el left join es para que me traiga ya cargala la lista de items
        "LEFT JOIN FETCH c.ItemsDeCatalogo " +
        "WHERE c.id = :id",
        CatalogoGeneral.class
    )
    .setParameter("id", 1L)
    .getSingleResult();
    
    //una ves traje el catalogo de la base de datos le pido la lista de items
    return c.getItemsDeCatalogo();
}
    
    
  public List<Proveedor> obtenerTodosLosProveedores(EntityManager em) {
    return em.createQuery(
            "SELECT p FROM Proveedor p ORDER BY p.nombre",
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



    public void AumentarStock(ItemDeSTOCK nuevoItemDeStock){    
        EntityManager em = FabricaEntityManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            // 1) Busco el catálogo general existente (hay 1 solo)
        Stock stock = em.createQuery("SELECT s FROM Stock c", Stock.class).setMaxResults(1).getResultStream().findFirst().orElse(null);
            // 2) Si no existe, lo creo y persisto
            if (stock == null) {
                stock = new Stock();
                em.persist(stock);
            }
            // 3) Lo asigno al item (porque es NOT NULL la realacion)
            nuevoItemDeStock.setStock(stock);
            // 4) Persisto el item
            em.persist(nuevoItemDeStock);
            et.commit();
        }
        catch(Exception e) {if (et.isActive()) {et.rollback();}throw new PersistenceException("Error al persistir item de Stock", e);} 
            finally {em.close();}
    }
}
