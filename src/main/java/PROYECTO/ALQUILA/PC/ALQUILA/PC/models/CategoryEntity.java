package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany()
    private List<ComputerEntity> computers=new ArrayList<ComputerEntity>();

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


    public List<ComputerEntity> getComputers() {
        return computers;
    }

    public void setComputers(List<ComputerEntity> computers) {
        this.computers = computers;
    }
}
