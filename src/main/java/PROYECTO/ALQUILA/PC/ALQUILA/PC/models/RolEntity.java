package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;
import javax.persistence.*;


@Entity
@Table(name = "ROL")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(unique = true)
    private String rolName;

    public RolEntity() {
    }

    public RolEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }
}
