package PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import javax.persistence.Entity;



@Entity
@Table(name = "ADMIN")

public class Admin implements Serializable {

    @Id
    private Integer id_admin;
    private String email;
    private String name;
    private String password;

    /**
     *
     * @param id_admin
     * @param email
     * @param name
     * @param password
     */
    public Admin(Integer id_admin, String email, String name, String password){

        this.setId_admin(id_admin);
        this.setEmail(email);
        this.setName(name);
        this.setPassword(password);
    }

    public Integer getId_admin() {
        return id_admin;
    }

    public void setId_admin(Integer id_admin) {
        this.id_admin = id_admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

