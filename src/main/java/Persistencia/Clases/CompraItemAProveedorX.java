package Persistencia.Clases;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "CompraItemAProveedorX")
public class CompraItemAProveedorX {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreProveedor;
    private String nombreItem;
    private Integer cantUnidades;
    private Float precioXUnidad;
    private Float precioTotal;
    private LocalDate fecha;
                    
    @ManyToOne
    @JoinColumn(name="historialGeneralID", nullable=false)
    private HistorialGeneral historialGeneral;


//Constructores
    public CompraItemAProveedorX() {}
    public CompraItemAProveedorX(String nombreProveedor, String nombreItem, Integer cantUnidades, Float precioXUnidad, Float precioTotal, LocalDate fecha){
        this.nombreProveedor = nombreProveedor;
        this.nombreItem = nombreItem;
        this.cantUnidades = cantUnidades;
        this.precioXUnidad = precioXUnidad;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
    }

//Getters y Setters
    public Long getId(){return this.id;}
    public String getNombreProveedor(){return this.nombreProveedor;}
    public String getNombreItem(){return this.nombreItem;}
    public Integer getCantUnidades() {return this.cantUnidades;}
    public Float getPrecioXunidad(){return this.precioXUnidad;}
    public Float getprecioTotal() {return this.precioTotal;}
    public LocalDate getFecha() {return this.fecha;}
    
    
    public void setHistorialGeneral(HistorialGeneral historial){this.historialGeneral = historial;}

    
}  