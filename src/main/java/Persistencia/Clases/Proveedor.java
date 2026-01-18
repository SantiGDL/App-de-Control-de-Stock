package Persistencia.Clases;

import Persistencia.DTOs.DTProveedor;
import Persistencia.DTOs.DTUsuario;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String contacto;
    private String ubicacion;
    private String descripcion;
    private String imagen;
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
    @OneToMany(mappedBy = "Proveedor", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ItemDeProveedorX> listaItemsVendidos;

    // Constructores
    public Proveedor() {}
    public Proveedor(String nombre, String contacto, String ubicacion, String descripcion, String imagen) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    // Getters y setters
    public Long getId() { return id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }


    //Contructor de DTProveedor --> Aca lo puedo
    public DTProveedor getDTProveedor() {
        DTProveedor dt = new DTProveedor(this.nombre, this.contacto, this.ubicacion, this.descripcion, this.imagen);
        return dt;
    }

}