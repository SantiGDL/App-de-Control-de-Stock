/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Clases;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
/**
 *
 * @author Santi-kun
 */
@Entity
@Table(name = "CompraItemAProveedorDefault")
public class CompraItemAProveedorDefault extends CompraItem {
    //Vinculo con Item comun, MUCHAS compras a UN item 
    @ManyToOne(optional = false)
    @JoinColumn(name="itemId", nullable=false) 
    private Item itemComun;


//Constructores
    public CompraItemAProveedorDefault() {}
    public CompraItemAProveedorDefault(String nombreItem, Item itemComprado,String imagenItem, String nombreProveedor,
        String imagenProveedor, Integer cantUnidades, Float precioXUnidad, Float precioTotal, LocalDate fecha) {
    super(nombreItem, imagenItem, nombreProveedor, imagenProveedor,  cantUnidades, precioXUnidad, precioTotal, fecha);
    this.itemComun = itemComprado;
    }

//Getters y Setters
    public Item getItemComprado(){return this.itemComun;}
}  