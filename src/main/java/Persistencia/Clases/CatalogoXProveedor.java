package Persistencia.Clases;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "CatalogoXProveedor")
public class CatalogoXProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreProveedor;
    //Este no es el dueño, el dueño de la relación es ItemDeProveedorX, y el campo por el que hago join es catXProv, ese es el que tengo que mapear
    @OneToMany(mappedBy = "catXProv" , cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ItemDeProveedorX> ItemsDeCatalogoDeProveedorX;        //Guardo items comunes en el stock, No me interesa de quien lo compré en el stock creo

    //Setters y Getters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public List<ItemDeProveedorX> getItemsDeCatalogoDeProveedorX() {return this.ItemsDeCatalogoDeProveedorX;}

}

/*Esto lo va rellenando el Usuario lentamente, cada ves que "compra" un nuevo item,
 es decir que aumenta su stock, entonces se toma el ItemDeSTOCK que previamente tiene que
 estár creado en el catálogo, sinó le doy la opción de crear un ItemDeSTOCK Nuevo.
Luego de Creado o Seleccionado el ItemDeSTOCK entonces pasa a elegir un Proveedor,
si previamente le había asignado un precio a ese item vendido por el proveedor
entonces aparece automático, sino se le pide que ingrese el precio por primera ves
acalarandole que luego queda automático pero que puede modificarlo si el precio
aumenta o algo así.
 */



/*Ejemplo de funcionamiento:
1: "Elija el ItemDeSTOCK que desea comprar, si este no se encuenta en el catálogo puede crear un nuevo item"
2: Ya sea que lo creó o que existía, ahora le pido que elija un proveedor, si no existe ningulo le pido que cree uno, sino le dejo en primera instancia los que ya tienen un precio el item porque lo compró previamente o si elije uno que no tiene precio o directamente no hay ninguna compra realizada entonces le tiene que cargar el precio al que lo está comprando y la cantidad de unidades.
3: Luego de elegido el item y el proveedor que lo vende habrán pasado una de 2 cosas, o el precio lo puso recién o ya estaba.
Si lo puso recién entonces se creó un nuevo registro en la tabla Catálogo x Proveedor, esa es una tabla invisible que el usuario no verá pero que se va cargando con cada compra realizada. Sinó se pasa directo al punto 4
4: Se aumenta el Stock Total con el item selecionado.
5: Se revisa el color de la alerta, si hay que cambiarla se cambia y sino se deja igual.
6: Se genera una nueva fila/instancia en la Tabla Historial General y una en Historial x Proveedor del Proveedor que le haya comprado
 */