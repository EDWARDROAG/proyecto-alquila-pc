package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class ComputerController {

    @Autowired
    IComputerService entityService;


    @PostMapping("/Computers")
    public ComputerEntity post(
             @RequestBody ComputerEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/Computers")

    public List<ComputerEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/Computers/{id}")
    public Optional<ComputerEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/Computers/{id}")
    public ComputerEntity put(@RequestBody ComputerEntity entity,
                              @PathVariable("id") Integer id) {

        return entityService.update(entity);
    }

    @DeleteMapping("/Computers/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
