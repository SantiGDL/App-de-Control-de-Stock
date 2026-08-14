package Persistencia.Clases;
import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTItemDeSTOCK;
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
        private boolean activo = true;
        //LOS UMBRALES DE LAS ALERTAS
        @Column(nullable = true)
        private Integer umbralRojo;
        @Column(nullable = true)
        private Integer umbralAmarillo;
        @ManyToOne
        @JoinColumn(name="stock_id", nullable=true)
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
        public void reducirStock(Integer cantUni){
            if (cantUni == null || cantUni <= 0) {
                throw new IllegalArgumentException("La cantidad a vender debe ser mayor que cero");
            }
            int disponible = this.cantUnidades == null ? 0 : this.cantUnidades;
            if (cantUni > disponible) {
                throw new IllegalArgumentException("No hay suficientes unidades en stock");
            }
            this.cantUnidades = disponible - cantUni;
        }
        
        //Seters y geters de umbrales de alertas
        public Integer getUmbralAmarillo(){return this.umbralAmarillo;}
        public void setUmbralAmarillo(Integer valor){this.umbralAmarillo = valor;}
        public Integer getUmbralRojo(){return this.umbralRojo;}
        public void setUmbralRojo(Integer valor){this.umbralRojo = valor;}
        
        
       @Transient
        public EstadoAlerta getEstadoAlerta() {
        if (umbralRojo == null || umbralAmarillo == null) return EstadoAlerta.GRIS;
        Integer cant = (cantUnidades == null) ? 0 : cantUnidades;
        if (cant <= umbralRojo) return EstadoAlerta.ROJO;
        if (cant <= umbralAmarillo) return EstadoAlerta.AMARILLO;
        //Si no es menor al umbral rojo ni amarillo es porque es mayor, o sea verrde
        return EstadoAlerta.VERDE;
}

   public DTItemDeSTOCK crearDTItemDeSTOCK(){
        DTItemDeSTOCK dt = new DTItemDeSTOCK(this.nombre, this.descripcion, this.imagen, this.cantUnidades,
        this.umbralAmarillo, this.umbralRojo, this.stock);
        return dt;
    }
   public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
        
}
