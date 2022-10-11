package PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Table(name = "category")

public class Category implements Serializable {
    @Id
    private Integer id;
    private String description;
    private String name;

    @JsonIgnoreProperties("category_fk")
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category_fk")
    private List <computer> computers;

    /**
     *
     * @param id
     * @param description
     * @param name
     */


    public Category(Integer id, String description, String name){
        this.setId(id);
        this.setDescription(description);
        this.setName(name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<computer> getComputers() {
        return computers;
    }

    public void setComputers(List<computer> computers) {
        this.computers = computers;
    }
}

