package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.CategoryEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository entityRepository;


    @Override
    public CategoryEntity add(CategoryEntity entity) {
        entityRepository.save(entity);
        return entity;

    }

    @Override
    public Optional<CategoryEntity> getById(Integer id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<CategoryEntity> getList() {
        return (List<CategoryEntity>) entityRepository.findAll();
    }

    @Override
    public CategoryEntity update(CategoryEntity entity) {
        entityRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        entityRepository.deleteById(id);
    }
}
