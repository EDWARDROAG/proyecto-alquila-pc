package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RolController {

    @Autowired
    IRolService entityService;




    @GetMapping("/api/Rol/all")

    public List<RolEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Rol/{id}")
    public Optional<RolEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }

    @PostMapping("/api/Rol/save")
    public ResponseEntity<?> post(
            @RequestBody RolEntity entity) {

        RolEntity RestModel= entityService.add(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }
    @PutMapping("/api/Rol/update")
    public ResponseEntity<?> put(@RequestBody RolEntity entity) {

        RolEntity RestModel= entityService.update(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/Rol/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
