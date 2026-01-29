package Persistencia.Clases;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "HistorialGeneral")
public class HistorialGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Relacion de UN historial general a MUCHAS compras
    @OneToMany(mappedBy="historialGeneralId", cascade=CascadeType.ALL, orphanRemoval=true)
    //LO HAGO GENERICO CON compraItem PARA PODER GUARDAR TANTO COMPRADEFAULT COMO A PROVEEDORX
    private List<CompraItem> compras = new ArrayList<>();        //Guardo items de Proveedor 
    //Constructor
    public HistorialGeneral(){}
    //Setters y Getters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    
    //LE AGREGO UNA COMPRA SIN IMPORTAR SI ES DE PROVEEDOR DEFAULT O X
    public void addCompra(CompraItem compraNueva){this.compras.add(compraNueva);}
    public List<CompraItem> getCompras() {return this.compras;}

}


