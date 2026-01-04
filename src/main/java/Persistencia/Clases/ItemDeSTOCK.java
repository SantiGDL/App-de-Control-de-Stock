package Persistencia.Clases;
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

//Getters y Setters
        public void setId(Long id) {this.id = id;}
        public Long getId() {return id;}
        public String getNombre(){return this.nombre;}
        public Integer getCantUnidades() {return cantUnidades;}
}
