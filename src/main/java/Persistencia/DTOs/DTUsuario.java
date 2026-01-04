package Persistencia.DTOs;

import Persistencia.Clases.Stock;

public class DTUsuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String imagen;
    private Stock stock;

    //Constructores
    public DTUsuario() {}
    public DTUsuario(String nickname, String nombre, String apellido, String imagen, Stock stock) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.stock = stock;
    }

    //Getters y Setters
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }


    public Stock getStock() {return stock;}
    public void setStock(Stock stock) {this.stock = stock;}
}