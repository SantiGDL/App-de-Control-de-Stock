package Persistencia.Clases;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CatalogoXProveedor")
public class CatalogoXProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreProveedor;
    
    @OneToOne(mappedBy = "catalogo", optional=false)
    private Proveedor proveedor;
    
    
    //Este no es el dueño, el dueño de la relación es ItemDeProveedorX, y el campo por el que hago join es catXProv, ese es el que tengo que mapear
    @OneToMany(mappedBy = "catXProv" , cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ItemDeProveedorX> ItemsDeCatalogoDeProveedorX  = new ArrayList<>();        //Guardo items comunes en el stock, No me interesa de quien lo compré en el stock creo

    //Setters y Getters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public List<ItemDeProveedorX> getItemsDeCatalogoDeProveedorX() {return this.ItemsDeCatalogoDeProveedorX;}
    public Proveedor getProveedor(){return this.proveedor;}
    public void addItem(ItemDeProveedorX item){
        ItemsDeCatalogoDeProveedorX.add(item);
        item.setCatXProv(this);
    }
    public void setProveedor(Proveedor prov) {
        this.proveedor = prov;
        if (prov != null && prov.getCatalogo() != this) {
            prov.setCatalogo(this);
    }
}
}
