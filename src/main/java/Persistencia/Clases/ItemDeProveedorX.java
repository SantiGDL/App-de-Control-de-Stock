package Persistencia.Clases;
import jakarta.persistence.*;

import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTProveedor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ItemsDeProveedorX")
public class ItemDeProveedorX{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Vinculo con Item MUCHOS ItemDeProveedorX a UN item 
    @ManyToOne //de muchos itemDeProveedorX a un solo item porque el item es unico.
    @JoinColumn(name="item_id", nullable=false)
    private Item ItemDeProveedor;
    
    @OneToMany (mappedBy="itemDeProveedor", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<CompraItemAProveedorX> comprasAProveedorX = new ArrayList<>();
    
    
    
    
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
        this.ItemDeProveedor = ItemVendido;
        this.Proveedor = Proveedor;
        this.precioItem = precioItem;
        this.costoFlete = costoFlete;
        this.costoTotal = costoTotal;
        this.tiempoDeEnvio = tiempoDeEnvio;
    }

}