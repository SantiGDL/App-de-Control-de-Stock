package Logica.Controladores;

import Persistencia.Clases.Item;
import Persistencia.Clases.Proveedor;
import Persistencia.Clases.Usuario;
import Persistencia.FabricaEntityManager;
import jakarta.persistence.EntityManager;
import Persistencia.ManejadorDePersistencia;

public class Controller implements IController {

    //Constructor
    public Controller(){}

    @Override
    public void crearItem(String nombre, String descripcion, String imagen){
        Item it = new Item(nombre, descripcion, imagen);
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        MDP.persistirItem(it);
    }
    
    @Override
    public void comprarItem(Usuario usu, Item item, Proveedor proveedor){

    }
    @Override
    public void crearProveedor(){

    }
    

}