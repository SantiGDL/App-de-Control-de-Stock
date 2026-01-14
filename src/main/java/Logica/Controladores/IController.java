package Logica.Controladores;

import Persistencia.Clases.Item;
import Persistencia.Clases.Proveedor;
import Persistencia.Clases.Usuario;

public interface IController {
    
    void crearItem(String nombre, String descripcion, String imagen);
    void comprarItem(Usuario usu, Item item, Proveedor proveedor);

    void crearProveedor();

}