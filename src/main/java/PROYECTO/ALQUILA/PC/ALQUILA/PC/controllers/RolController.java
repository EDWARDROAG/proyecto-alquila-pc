package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RolController {

    @Autowired
    IRolService entityService;


    @PostMapping("/Rol")
    public RolEntity post(
             @RequestBody RolEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/Rol")

    public List<RolEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/Rol/{id}")
    public Optional<RolEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/Rol/{id}")
    public RolEntity put(@RequestBody RolEntity entity,
                              @PathVariable("id") Integer id) {

        return entityService.update(entity);
    }

    @DeleteMapping("/Rol/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
