/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Clases;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Santi-kun
 */
@Entity
@Table(name = "CompraItem")
public class CompraItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreItem;
    private String imagenItem;
    private String nombreProveedor;
    private String imagenProveedor;
    private Integer cantUnidades;
    private Float precioXUnidad;
    private Float precioTotal;
    private LocalDate fecha;
    //------> Acá hago el JOIN entre VARIAS compras a UN historial general <------          
    @ManyToOne
    @JoinColumn(name="historialGeneralId", nullable=false)
    private HistorialGeneral historialGeneral;
    //-----> Acá hago el JOIN entre MUCHAS compras a UN historial x proveedor <-------
    @ManyToOne
    @JoinColumn(name="historialXProveedorId", nullable=false)
    private HistorialXProveedor historialXProveedor;


//Constructores
    public CompraItem() {}
    public CompraItem(String nombreItem,String imagenItem, String nombreProveedor, String imagenProveedor, Integer cantUnidades, Float precioXUnidad, Float precioTotal, LocalDate fecha){
        this.nombreItem = nombreItem;
        this.imagenItem = imagenItem;
        this.nombreProveedor = nombreProveedor;
        this.imagenProveedor = imagenProveedor;
        this.cantUnidades = cantUnidades;
        this.precioXUnidad = precioXUnidad;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
    }

//Getters y Setters
    public Long getId(){return this.id;}
    public String getNombreItem(){return this.nombreItem;}
    public String getImagenItem(){return this.imagenItem;}
    public String getNombreProveedor(){return this.nombreProveedor;}
    public String getImagenProveedor(){return this.imagenProveedor;}
    public Integer getCantUnidades() {return this.cantUnidades;}
    public Float getPrecioXunidad(){return this.precioXUnidad;}
    public Float getPrecioTotal() {return this.precioTotal;}
    public LocalDate getFecha() {return this.fecha;}
    
    
    //FUNCIONES PARA SETEAR HISTORIALES
    public void setHistorialXProveedor(HistorialXProveedor historial){this.historialXProveedor = historial;}
    public void setHistorialGeneral(HistorialGeneral historial){this.historialGeneral = historial;}
  
}  