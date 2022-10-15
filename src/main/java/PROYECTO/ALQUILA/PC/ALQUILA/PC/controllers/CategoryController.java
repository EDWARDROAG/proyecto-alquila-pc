package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.CategoryEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    ICategoryService entityService;


    @PostMapping("/api/Category/save")
    public CategoryEntity post(
             @RequestBody CategoryEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/api/Category/all")

    public List<CategoryEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Category/{id}")
    public Optional<CategoryEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/api/Category/{id}")
    public CategoryEntity put(@RequestBody CategoryEntity entity,
                              @PathVariable("id") Integer id) {

        return entityService.update(entity);
    }

    @DeleteMapping("/api/Category/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
