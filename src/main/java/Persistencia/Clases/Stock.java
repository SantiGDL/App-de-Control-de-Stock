//Stock solo guarda Items, no hace nada más, las operaciones como obtener la cantidad de items se hacen en el Manejador de Stock
package Persistencia.Clases;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //lo dejo que se cree solo, me da igual el id con el que se genere, mientras que al crear el usuario
    //le pase el mismo stock que cree previamente da lo mismo, o sea Usuario admin = new Usuario(stock1) -> Ahí le paso el stock1 asi que da igual el id, siempre va
    //a pasarle el id del primer stock que cree.
    private Long id;
    @OneToMany(mappedBy="stock", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ItemDeSTOCK> itemsDeStock = new ArrayList<>(); //Guardo items comunes en el stock, No me interesa de quien lo compré en el stock creo


//Constructor
    public Stock() {}

//Setters y Getters
    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public List<ItemDeSTOCK> getItemsDeSTOCK() {return this.itemsDeStock;}
//Funciones
    public void addItemDeStock(ItemDeSTOCK item) {
        itemsDeStock.add(item);
    }

    public void removeItemDeStock(ItemDeSTOCK item){
        itemsDeStock.remove(item);
    }
}