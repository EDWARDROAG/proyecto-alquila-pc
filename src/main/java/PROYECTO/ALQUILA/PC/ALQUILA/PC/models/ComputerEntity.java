package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "COMPUTER")
public class ComputerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String brand;
    private String year;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CategoryEntity category;
    private String name;
    private String description;







    @OneToMany()
    private List<MessageEntity> messages=new ArrayList<MessageEntity>();

    @OneToMany()
    private List<ReservationEntity> reservations=new ArrayList<ReservationEntity>();
    public ComputerEntity() {
    }
    

    public ComputerEntity(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }
}

