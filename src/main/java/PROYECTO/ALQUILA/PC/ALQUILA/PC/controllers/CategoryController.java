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

    public ResponseEntity<?> getAll() {

        try {
            List<CategoryEntity> list= entityService.getList();
            return  new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/Category/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {


        try {
            Optional<CategoryEntity> entity= entityService.getById(id);
            return  new ResponseEntity<>(entity, HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/Category/save")
    public ResponseEntity<?> post(
            @RequestBody CategoryEntity entity) {



        try {
            CategoryEntity RestModel= entityService.add(entity);
            return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/api/Category/update")
    public ResponseEntity<?> put(@RequestBody CategoryEntity entity) {



        try {
            CategoryEntity RestModel= entityService.update(entity);
            return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/Category/{id}")

    public ResponseEntity<?> delete(@PathVariable("id")Integer id) {
        try {
            entityService.delete(id);
            return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
