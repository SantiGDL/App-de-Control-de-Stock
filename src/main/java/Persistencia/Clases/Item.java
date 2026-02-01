package Persistencia.Clases;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import Persistencia.Clases.ItemDeProveedorX;
import Persistencia.DTOs.DTItem;
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
    private boolean activo = true;


    
    
    @ManyToOne
    @JoinColumn(name="catalogo", nullable=false)
    private CatalogoGeneral catalogo;

    //Vinculo con ItemDeProveedorX, UN item a MUCHOS ITEMS DE PROVEEDORX
    @OneToMany(mappedBy="item", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ItemDeProveedorX> listaDeItemsDeProveedorX = new ArrayList<>();;   //Serian todos los Item de Proveedor que se crean a partir de un solo Item
    
    //Vinculo con CompraItemAProveedorDefault, UN item a MUCHAS COMPRAS
    @OneToMany(mappedBy="itemComun", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<CompraItemAProveedorDefault> listaDeComprasDeProveedorDefault = new ArrayList<>();;


//Constructores
    public Item() {}
    public Item(String nombre, String descripcion, String imagen){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

//Getters y Setters
    public Long getId(){return this.id;}
    public String getNombre(){return this.nombre;}
    public String getDescripcion(){return this.descripcion;}
    public String getImagen() {return this.imagen;}
    public void setCatalogo(CatalogoGeneral cat){this.catalogo = cat;}

    public DTItem crearDTItem(){
        DTItem dt = new DTItem(this.nombre, this.descripcion, this.imagen);
        return dt;
    }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}  