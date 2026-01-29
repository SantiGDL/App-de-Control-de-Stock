package Persistencia.Clases;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name = "CompraItemAProveedorX")
public class CompraItemAProveedorX  extends CompraItem{
    private String nombreProveedor;
    @OneToOne
    @JoinColumn(name="item_id", nullable=false)
    private ItemDeProveedorX itemDeProveedor;

//Constructores
    public CompraItemAProveedorX() {}
    public CompraItemAProveedorX(String nombreItem, ItemDeProveedorX itemDeProveedor, String imagenItem,
        String nombreProveedor, String imagenProveedor, Integer cantUnidades, Float precioXUnidad, Float precioTotal, LocalDate fecha){
        super(nombreItem, imagenItem, nombreProveedor, imagenProveedor, cantUnidades, precioXUnidad, precioTotal, fecha);
        this.itemDeProveedor = itemDeProveedor;
    }
//Getters y Setters
    public String getNombreProveedor(){return this.nombreProveedor;}
    public ItemDeProveedorX getItemComprado(){return this.itemDeProveedor;} 
}  