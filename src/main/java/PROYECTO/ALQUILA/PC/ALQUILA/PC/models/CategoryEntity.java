package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    private String description;


    public CategoryEntity() {
    }
    

    public CategoryEntity(int id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
