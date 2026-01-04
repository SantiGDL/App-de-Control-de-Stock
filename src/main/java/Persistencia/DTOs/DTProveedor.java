package Persistencia.DTOs;

public class DTProveedor {
    private String nombre;
    private String contacto;
    private String ubicacion;
    private String descripcion;
    private String imagen;

    //Constructores --> CREO QUE EL CONSTRUCTOR POR PARAMETROS NO LO NECESITO YA QUE TENGO EL CONSTRUCTOR EN PROVEEDOR.JAVA PERO LO DEJO POR LAS DUDAS
    public DTProveedor() {}
    public DTProveedor(String nombre, String contacto, String ubicacion, String descripcion, String imagen) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    //Getters y Setters
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



}