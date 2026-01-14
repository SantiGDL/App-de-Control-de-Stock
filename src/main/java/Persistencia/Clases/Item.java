package Persistencia.Clases;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import Persistencia.Clases.ItemDeProveedorX;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    @ManyToOne
    @JoinColumn(name="catalogo", nullable=false)
    private CatalogoGeneral catalogo;

    @OneToMany(mappedBy="ItemVendido", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ItemDeProveedorX> listaDeItemsDeProveedorX;   //Serian todos los Item de Proveedor que se crean a partir de un solo Item
    //o sea que si el item es cableUTPExterior, tendria cableUTPExterior vendido por CDRMedios y por SuperCables, etc. Cada uno
    //genera una nueva insancia de ItemDeProveedorX que la entidad "Item" va a tener vinculada como una lista.




//Constructores
    public Item() {}
    public Item(String nombre, String descripcion, String imagen){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

//Getters y Setters
    String getNombre(){return this.nombre;}
    public void setCatalogo(CatalogoGeneral cat){this.catalogo = cat;}


}