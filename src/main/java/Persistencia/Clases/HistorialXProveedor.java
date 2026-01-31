package Persistencia.Clases;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "HistorialXProveedor")
public class HistorialXProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorialXProveedor;
    //-------> Acá hago el join entre UN historial X Proveedor a MUCHAS compras
    @OneToMany(mappedBy="historialXProveedor", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<CompraItem> compras = new ArrayList<>();        //Guardo items de Proveedor 
    //-------> Acá hago el JOIN entre UN Proveedor y UN Historial X Proveedor <---------
    @OneToOne
    @JoinColumn(name="proveedor_id", unique=true, nullable=false)
    private Proveedor proveedorVinculado;
    

    //Lo dejo como CompraItem asi puedo guardar CompraAProveedorDefault y CompraAProveedorX
    //Constructor
    public HistorialXProveedor(){}
    //Setters y Getters
    public Long getIdHistorialXProveedor() {return idHistorialXProveedor;}
    public void setIdHistorialXProveedor(Long id) {this.idHistorialXProveedor = id;}
    public List<CompraItem> getCompras() {return this.compras;}
    
    public void addCompra(CompraItem compraNueva){
    this.compras.add(compraNueva);
    compraNueva.setHistorialXProveedor(this);
    }
    public void removeCompra(CompraItem c){
    this.compras.remove(c);
    c.setHistorialXProveedor(null);
    }
    
    public void setProveedor(Proveedor p){this.proveedorVinculado = p;}
    
}