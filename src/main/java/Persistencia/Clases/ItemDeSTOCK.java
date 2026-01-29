package Persistencia.Clases;
import Persistencia.DTOs.DTItem;
import jakarta.persistence.*;

@Entity
@Table(name = "ItemsDeSTOCK")
    public class ItemDeSTOCK {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String descripcion;
        private String imagen;
        private Integer cantUnidades;
        private EstadoAlerta estadoAlerta = EstadoAlerta.GRIS;
        @ManyToOne
        @JoinColumn(name="stock_id", nullable=false)
        private Stock stock;
        //Constructor
        public ItemDeSTOCK() {}
        public ItemDeSTOCK(String nombre, String descripcion, String imagen, Integer cantUnidades){
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.imagen = imagen;
            this.cantUnidades = cantUnidades;

        }
        public ItemDeSTOCK(DTItem dt, Integer cantUnidades) {
        this.nombre = dt.getNombre();
        this.descripcion = dt.getDescripcion();
        this.imagen = dt.getImagen();
        this.cantUnidades = cantUnidades;}

//Getters y Setters
        public void setId(Long id) {this.id = id;}
        public Long getId() {return id;}
        public String getNombre(){return this.nombre;}
        public String getDescripcion(){return this.descripcion;}
        public String getImagen(){return this.imagen;}
        public Integer getCantUnidades() {return cantUnidades;}
        public void setStock(Stock stock){this.stock = stock;}
        public void aumentarStock(Integer cantUni){this.cantUnidades = this.cantUnidades + cantUni;}
}
