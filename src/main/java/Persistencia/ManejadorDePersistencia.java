package Persistencia;

import Persistencia.Clases.CatalogoGeneral;
import Persistencia.Clases.Item;
import Persistencia.Clases.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

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


}
