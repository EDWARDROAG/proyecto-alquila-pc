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
@Table(name = "CATEGORY")

public class Category implements Serializable {
    @Id
    private Integer id_category;
    private String description;
    private String name;

    @JsonIgnoreProperties("category_fk")
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category_fk")
    private List <Computer> computers;

    /**
     *
     * @param id_category
     * @param description
     * @param name
     */


    public Category(Integer id_category, String description, String name){
        this.setId(id_category);
        this.setDescription(description);
        this.setName(name);
    }

    public Integer getId() {
        return id_category;
    }

    public void setId(Integer id) {
        this.id_category = id_category;
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

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
}

