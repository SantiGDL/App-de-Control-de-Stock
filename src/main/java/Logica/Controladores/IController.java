package Logica.Controladores;

import Persistencia.Clases.Item;
import Persistencia.Clases.Proveedor;
import Persistencia.Clases.Usuario;

public interface IController {

    void ComprarItem(Usuario usu, Item item, Proveedor proveedor);

    void CrearProveedor();

}