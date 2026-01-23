package Persistencia.Clases;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "historialGeneral")
public class HistorialGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy="historialGeneral", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<CompraItemAProveedorX> compras = new ArrayList<>();        //Guardo items de Proveedor 

    //Constructor
    public HistorialGeneral(){}
    //Setters y Getters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public List<CompraItemAProveedorX> getcompras() {return this.compras;}

}


