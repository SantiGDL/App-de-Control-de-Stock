package Persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FabricaEntityManager {
    private static final String PERSISTENCE_UNIT = "stockPU";
    //Fabrica, crea la entity manager, cara de crear, por eso singleton
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    //Entity Manager, obtengo la instancia
    public static EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

}
