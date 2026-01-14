import Persistencia.Clases.CatalogoGeneral;
import Persistencia.Clases.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Persistencia.Clases.Stock;
import Persistencia.ManejadorDePersistencia;

public class Main {
    public static void main(String[] args) {
        //Traigo la instancia del manejador de persistencias
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        //Creo el Catalogo General
        CatalogoGeneral cat = new CatalogoGeneral();
        //Persisto el Catalogo General
        MDP.persistirCatalogoGeneral(cat);
        //Creo el item
        Item it = new Item("PC Gamer", "PC de escritorio con i7 de 3ra genenracion, 8gb de ram, 1tb HDD, GTX1080TI de GPU en gabinete Gamer negro", "URL IMAGEN");
        //Seteo el catalogo general donde va a ir el item, podria ser un catalogo X proveedor por ejemplo tambien
        it.setCatalogo(cat);
        //Persisto el item con el catalogo General ya creado
        MDP.persistirItem(it);
        System.out.println("Todo OK");
    }
    }
/*
        em.getTransaction().begin();

        // opcional: persistir algo para ver inserts
        Stock s = new Stock();
        em.persist(s);

        em.getTransaction().commit();
*/




