package PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "CLIENT")

public class Client implements Serializable {
    @Id
    private Integer id_client;
    private Integer age;
    private String email;
    private String name;
    private String password;

    @JsonIgnoreProperties("client_fk")
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client_fk")
    private List<Message> messages;

    /**
     *
     * @param id_client
     * @param age
     * @param email
     * @param name
     * @param password
     */
    public Client(Integer id_client, Integer age, String email, String name, String password) {
        this.setId_client(id_client);
        this.setAge(age);
        this.setEmail(email);
        this.setName(name);
        this.setPassword(password);
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
