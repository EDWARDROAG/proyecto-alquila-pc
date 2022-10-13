package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCRUDRepository categoryCRUDRepository;

    /**
     *
     * @return
     */
    public List<Category> getAll(){
        return (List<Category>) categoryCRUDRepository.findAll();

    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Category> getCategory(int id){
        return categoryCRUDRepository.findById(id);


    }

    /**
     *
     * @param category
     * @return
     */
    public Category save(Category category){
        return categoryCRUDRepository.save(category);


    }

    /**
     *
     * @param category
     */
    public void delete(Category category){
        categoryCRUDRepository.delete(category);

    }
}
