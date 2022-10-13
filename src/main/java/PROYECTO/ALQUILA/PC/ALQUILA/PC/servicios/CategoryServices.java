package PROYECTO.ALQUILA.PC.ALQUILA.PC.servicios;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Category;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.getAll();


    }

    public Optional<Category> getCategory(int id_category){
        return categoryRepository.getCategory(id_category);


    }

    public Category insertEditorial(Category category){

    }

    public Category updateEditorial(Category category){

    }

    public Boolean deleteCategory(int id_category){
        Boolean success = categoryRepository.getCategory(id_category).map(category -> {
            categoryRepository.delete(category);
            return true;

        }).orElse(false);
        return  success;
    }
}



