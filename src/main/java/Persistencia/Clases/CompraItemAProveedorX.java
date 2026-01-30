package Persistencia.Clases;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity 
@Table(name = "CompraItemAProveedorX")
public class CompraItemAProveedorX  extends CompraItem{
    //Vinculo con tabla Item De ProveedorX, MUCHAS compras a UN item
    @ManyToOne
    @JoinColumn(name="itemDeProveedorId", nullable=false) 
    private ItemDeProveedorX itemDeProveedor;

//Constructores
    public CompraItemAProveedorX() {}
    public CompraItemAProveedorX(String nombreItem, ItemDeProveedorX itemDeProveedor, String imagenItem,
        String nombreProveedor, String imagenProveedor, Integer cantUnidades, Float precioXUnidad, Float precioTotal, LocalDate fecha){
        super(nombreItem, imagenItem, nombreProveedor, imagenProveedor, cantUnidades, precioXUnidad, precioTotal, fecha);
        this.itemDeProveedor = itemDeProveedor;
    }
//Getters y Setters
    public ItemDeProveedorX getItemComprado(){return this.itemDeProveedor;} 
}  