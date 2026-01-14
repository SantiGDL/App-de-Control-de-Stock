package Persistencia;

import Persistencia.Clases.CatalogoGeneral;
import Persistencia.Clases.Item;
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
            em.persist(nuevoItem);
            et.commit();
            }
        catch(Exception e) {
            if (et.isActive()) et.rollback();
            throw new PersistenceException("Error al persistir item", e);
                } 
            finally {em.close();}
    }
    
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





}
