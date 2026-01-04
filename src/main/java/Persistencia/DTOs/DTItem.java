package Persistencia.DTOs;

public class DTItem {
    private String nombre;
    private String descripcion;
    private String imagen;

    //Constructores
    public DTItem() {}
    public DTItem(String nombre, String descripcion, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }


    //Getters y Setters
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = this.descripcion;}

    public String getImagen() {return imagen;}
    public void setImagen(String imagen) {this.imagen = imagen;}
}