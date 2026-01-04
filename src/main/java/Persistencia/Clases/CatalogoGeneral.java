package Persistencia.Clases;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CatalogoGeneral")
public class CatalogoGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Atributos
    private Long id;
    @OneToMany(mappedBy="catalogo", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Item> ItemsDeCatalogo = new ArrayList<>();        //Guardo items comunes en el stock, No me interesa de quien lo compré en el stock creo

    //Setters y Getters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public List<Item> getItemsDeCatalogo() {return this.ItemsDeCatalogo;}

}
