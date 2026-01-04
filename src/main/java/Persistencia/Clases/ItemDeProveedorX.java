package Persistencia.Clases;
import jakarta.persistence.*;

import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTProveedor;

@Entity
@Table(name = "ItemsDeProveedorX")
public class ItemDeProveedorX{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne //de muchos itemDeProveedorX a un solo item porque el item es unico.
    @JoinColumn(name="item_id", nullable=false)
    private Item ItemVendido;
    @ManyToOne
    @JoinColumn(name="Proveedor", nullable=false)
    private Proveedor Proveedor;
    @ManyToOne
    @JoinColumn(name="catalogoGral_id", nullable=false)
    private CatalogoGeneral catGral;
    @ManyToOne
    @JoinColumn(name="catalogoXProv_id", nullable=false)
    private CatalogoXProveedor catXProv;
    private Float precioItem;
    private Float costoFlete;
    private Float costoTotal;
    private String tiempoDeEnvio;

    //Constructor
    public ItemDeProveedorX() {}
    public ItemDeProveedorX(Item ItemVendido, Proveedor Proveedor, Float precioItem, Float costoFlete, Float costoTotal, String tiempoDeEnvio){
        this.ItemVendido = ItemVendido;
        this.Proveedor = Proveedor;
        this.precioItem = precioItem;
        this.costoFlete = costoFlete;
        this.costoTotal = costoTotal;
        this.tiempoDeEnvio = tiempoDeEnvio;
    }

}