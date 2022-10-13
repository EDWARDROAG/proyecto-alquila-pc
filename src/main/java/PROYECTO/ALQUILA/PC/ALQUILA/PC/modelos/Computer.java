package PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "COMPUTER")

public class Computer implements Serializable  {
    @Id
    private Integer id_Computer;
    private String brand;
    private String description;
    private String name;
    private Integer age;

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("computers")
    private Category category_fk;

    @JsonIgnoreProperties("computer_fk")
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer_fk")
    private List <Message> messageList;

    @JsonIgnoreProperties("client_fk")
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client_fk")
    private List <Client> clients;


    /**
     *
     * @param id_Computer
     * @param brand
     * @param description
     * @param name
     * @param age
     */
    public Computer(Integer id_Computer, String brand, String description, String name, Integer age){
        this.setId(getId());
        this.setBrand(brand);
        this.setDescription(description);
        this.setName(name);
        this.setAge(age);

    }

    public Integer getId() {
        return id_Computer;
    }

    public void setId(Integer id) {
        this.id_Computer = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Category getCategory_fk() {
        return category_fk;
    }

    public void setCategory_fk(Category category_fk) {
        this.category_fk = category_fk;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
