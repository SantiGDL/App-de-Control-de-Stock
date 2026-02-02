package Persistencia.Clases;
import jakarta.persistence.*;

import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTProveedor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ItemsDeProveedorX",uniqueConstraints = @UniqueConstraint(columnNames = {"proveedor_id", "item_id"}))
public class ItemDeProveedorX{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Vinculo con Item MUCHOS ItemDeProveedorX a UN item 
    @ManyToOne //de muchos itemDeProveedorX a un solo item porque el item es unico.
    @JoinColumn(name="item_id", nullable=false)
    private Item item;
    @OneToMany (mappedBy="itemDeProveedor")
    private List<CompraItemAProveedorX> comprasAProveedorX = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="proveedor_id", nullable=false)
    private Proveedor proveedor;
    @ManyToOne
    @JoinColumn(name="catalogoXProv_id", nullable=false)
    private CatalogoXProveedor catXProv;
    
    private Float precioItem;
    private Float costoFlete;
    private Float costoTotal;
    private String tiempoDeEnvio;
    private boolean activo = true;

    //Constructor
    public ItemDeProveedorX() {}
    public ItemDeProveedorX(Item ItemVendido, Proveedor proveedor, Float precioItem, Float costoFlete, Float costoTotal, String tiempoDeEnvio){
        this.item = ItemVendido;
        this.proveedor = proveedor;
        this.precioItem = precioItem;
        this.costoFlete = costoFlete;
        this.costoTotal = costoTotal;
        this.tiempoDeEnvio = tiempoDeEnvio;
    }
    
    //GETTERS y SETTERS
    public Item getItem() { return item; }
    public Long getId(){return this.id;}
    public String getNombre(){return this.item.getNombre();}
    public String getDescripcion() {return this .item.getDescripcion();}
    public String getImagen() {return this.item.getImagen();}
    
    //PrecioItem
    public void setPrecioItem(Float precio){this.precioItem = precio;}
    public Float getPrecioItem(){return this.precioItem;}
    //CostoFloete
    public void setCostoFlete(Float costoFlete){this.costoFlete = costoFlete;}
    public Float getCostoFlete(){return this.costoFlete;}
    //CostoTotal
    public void setCostoTotal(Float precio){this.costoTotal = precio;}
    public Float getCostoTotal(){return this.costoTotal;}
    //TiempoEnvio
    public void setTiempoDeEnvio(String timepoEnvio){this.tiempoDeEnvio = timepoEnvio;}
    public String getTiempoDeEnvio(){return this.tiempoDeEnvio;}
    
    public Proveedor getProveedor() { return proveedor; }
    public void setItem(Item item) { this.item = item; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }
    //CatalogoXPorveedor
    public CatalogoXProveedor getCatXProv() {return catXProv;}
    public void setCatXProv(CatalogoXProveedor catXProv) {this.catXProv = catXProv;}

}