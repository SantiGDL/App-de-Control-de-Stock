package Logica;
import Persistencia.Clases.*;
import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTProveedor;

import java.util.List;

public class ManejadorDeStock {
    private Stock stock;
    private List<ItemDeSTOCK> items = stock.getItemsDeSTOCK();

    //Constructor
    public ManejadorDeStock(Stock stock) {}

    //Funciones
    public int obtenerCantUnidades(String nombreItem) throws Exception {
        for (ItemDeSTOCK i : items) {
            if (i.getNombre() != null && i.getNombre().equalsIgnoreCase(nombreItem)) {
                Integer cant = i.getCantUnidades();
                if (cant == null) {
                    return 0;
                } else {
                    return cant;
                }       //la otra forma de escribir esta expreción es "return (cant != null) ? cant : 0;"
            }
        }
        throw new Exception("El ítem buscado nunca se ha comprado antes; debe ingresarlo al stock primero.");
    }

    //Funcion para crear un Item de Proveedor X, para ello necesito los datos del Item, del Proveedor que lo vende y le fijo aqui tambien los precios y tiempo de envio
    public ItemDeProveedorX generarItemDeProveedorX(Item ItemVendido, Proveedor Proveedor, Float precioItem, Float costoFlete, Float costoTotal, String tiempoDeEnvio){
        ItemDeProveedorX itemCreado = new ItemDeProveedorX(ItemVendido, Proveedor, precioItem, costoFlete,  costoTotal, tiempoDeEnvio);
        return itemCreado;
    }
/*
    public ItemDeSTOCK generarItemDeSTOCK(Item item){
        ItemDeSTOCK itemCreado = new ItemDeSTOCK()
    }
*/
    //El usuario va a llamar a esta funcion para comprar
    public void AumentarStock(ItemDeSTOCK item){

    }

}