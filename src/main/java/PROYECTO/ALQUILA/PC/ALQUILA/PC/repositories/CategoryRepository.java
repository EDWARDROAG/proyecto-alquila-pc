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

    public List<Category> getAll(){
        return (List<Category>) categoryCRUDRepository.findAll();

    }

    public Optional<Category> getcategory(int code){
        return categoryCRUDRepository.findById(code);


    }

    public Category save(Category category){
        return categoryCRUDRepository.save(category);


    }

    public void delete(Category category){
        categoryCRUDRepository.delete(category);

    }
}
