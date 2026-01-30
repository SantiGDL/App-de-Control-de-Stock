package Persistencia.Clases;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CatalogoGeneral")
public class CatalogoGeneral {
    @Id
    @Column(unique = true, nullable = false)
    private String clave = "DEFAULT";
    @OneToMany(mappedBy="catalogo", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Item> itemsDeCatalogo = new ArrayList<>();        //Guardo items comunes en el stock, No me interesa de quien lo compré en el stock creo

    //Constructor
    public CatalogoGeneral(){}
    //Setters y Getters
    public String getClave() {return clave;}
    public void setId(String clave) {this.clave = clave;}
    public List<Item> getItemsDeCatalogo() {return this.itemsDeCatalogo;}

}
