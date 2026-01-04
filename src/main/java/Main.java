import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Persistencia.Clases.Stock;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stockPU");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
        System.out.println("OK - JPA levantó");
    }
    }
/*
        em.getTransaction().begin();

        // opcional: persistir algo para ver inserts
        Stock s = new Stock();
        em.persist(s);

        em.getTransaction().commit();
*/




