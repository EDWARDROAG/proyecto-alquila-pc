package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class ComputerController {

    @Autowired
    IComputerService entityService;




    @GetMapping("/api/Computer/all")

    public List<ComputerEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Computer/{id}")
    public Optional<ComputerEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }

    @PostMapping("/api/Computer/save")
    public ResponseEntity<?> post(
            @RequestBody ComputerEntity entity) {

        ComputerEntity RestModel= entityService.add(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @PutMapping("/api/Computer/update")
    public ResponseEntity<?> put(@RequestBody ComputerEntity entity) {

        ComputerEntity RestModel= entityService.update(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/Computer/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
