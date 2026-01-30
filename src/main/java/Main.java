import Persistencia.Clases.CatalogoGeneral;
import Persistencia.Clases.Item;
import Persistencia.Clases.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Persistencia.Clases.Stock;
import Persistencia.FabricaEntityManager;
import Persistencia.ManejadorDePersistencia;

public class Main {
    public static void main(String[] args) {
        
        //Creo el proveedor Default y lo persisto
        String urlImagenDefault = "";
        Proveedor ProveedorDefault = new Proveedor("DEFAULT", "-", "-", "Seleccione este Proveedor cuando no quiera especificar uno", urlImagenDefault);        
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        MDP.persistirProveedor(ProveedorDefault);
        
    }
    }





