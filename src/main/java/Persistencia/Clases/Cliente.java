package Persistencia.Clases;
import jakarta.persistence.*;


@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String nombre;
    private String apellido;
    private String imagen;

    //Constructor

    public Cliente(){}
    public Cliente(String nickname, String nombre,String apellido, String imagen) {
            this.nickname = nickname;
            this.nombre = nombre;
            this.apellido = apellido;
            this.imagen = imagen;
        }
}





