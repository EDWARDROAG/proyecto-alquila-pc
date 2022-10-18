package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;
import org.apache.catalina.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;





    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private Integer age;




    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RolEntity rol;


    @OneToMany()
    private List<MessageEntity> messages=new ArrayList<MessageEntity>();

    @OneToMany()
    private List<ReservationEntity> reservations=new ArrayList<ReservationEntity>();

    public UserEntity() {
    }

    public UserEntity(int id, String name, String email, Integer age, String password, RolEntity rol) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.rol = rol;
    }

    public UserEntity(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;


    }
}
