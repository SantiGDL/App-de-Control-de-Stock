/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DTOs;

import Persistencia.Clases.Stock;

/**
 *
 * @author Santi-kun
 */
public class DTItemDeSTOCK {
    private String nombre;
    private String descripcion;
    private String imagen;
    private Integer cantUnidades;
    private Integer umbralRojo;
    private Integer umbralAmarillo;
    private Stock stock;
    private boolean activo = true;

    //Constructores
    public DTItemDeSTOCK() {}
    public DTItemDeSTOCK(String nombre, String descripcion, String imagen, Integer cantUni, Integer umbralRojo,
            Integer umbralAmarillo, Stock stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.cantUnidades = cantUni;
        this.umbralAmarillo = umbralAmarillo;
        this.umbralRojo = umbralRojo;
        this.stock = stock;
    }


    //Getters y Setters
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = this.descripcion;}

    public String getImagen() {return imagen;}
    public void setImagen(String imagen) {this.imagen = imagen;}
    
    


}

