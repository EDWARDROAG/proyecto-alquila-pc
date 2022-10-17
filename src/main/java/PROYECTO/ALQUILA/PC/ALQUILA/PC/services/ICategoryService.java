package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    CategoryEntity add (CategoryEntity entity);
    Optional<CategoryEntity> getById (Integer id);

    List<CategoryEntity> getList();

    CategoryEntity update(CategoryEntity Category);

    void delete(Integer id);
}


