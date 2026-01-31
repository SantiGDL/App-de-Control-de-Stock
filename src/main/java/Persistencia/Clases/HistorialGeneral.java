package Persistencia.Clases;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "HistorialGeneral")
public class HistorialGeneral {
    @Id
    @Column(unique = true, nullable = false)
    private String clave = "GENERAL";
    //Relacion de UN historial general a MUCHAS compras
    @OneToMany(mappedBy="historialGeneral", cascade=CascadeType.ALL, orphanRemoval=true)    //LO HAGO GENERICO CON compraItem PARA PODER GUARDAR TANTO COMPRADEFAULT COMO A PROVEEDORX
    private List<CompraItem> compras = new ArrayList<>();        //Guardo items de Proveedor 
    //Constructor
    public HistorialGeneral(){
    this.clave = "GENERAL";}
    //Setters y Getters
    public String getClave() {return clave;}    
    //LE AGREGO UNA COMPRA SIN IMPORTAR SI ES DE PROVEEDOR DEFAULT O X
    public void addCompra(CompraItem compraNueva){
    this.compras.add(compraNueva);
    compraNueva.setHistorialGeneral(this);
    }
    public void removeCompra(CompraItem c){
    this.compras.remove(c);
    c.setHistorialGeneral(null);
    }
    public List<CompraItem> getCompras() {return this.compras;}

}


