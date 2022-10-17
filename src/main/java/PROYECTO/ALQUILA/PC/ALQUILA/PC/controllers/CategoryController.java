package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.CategoryEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    ICategoryService entityService;




    @GetMapping("/api/Category/all")

    public List<CategoryEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Category/{id}")
    public Optional<CategoryEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }

    @PostMapping("/api/Category/save")
    public ResponseEntity<?> post(
            @RequestBody CategoryEntity entity) {

        CategoryEntity RestModel= entityService.add(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }
    @PutMapping("/api/Category/update")
    public ResponseEntity<?> put(@RequestBody CategoryEntity entity) {

        CategoryEntity RestModel= entityService.update(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/Category/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
