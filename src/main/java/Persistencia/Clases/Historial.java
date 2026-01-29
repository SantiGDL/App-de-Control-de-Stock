/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package Persistencia.Clases;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Constructor
    public Historial(){}
    //Setters y Getters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public void setIdProveedor(Long idProveedor) {this.idProveedor = idProveedor;}
    public Long getIdProveedor() {return this.idProveedor;}

}
*/

