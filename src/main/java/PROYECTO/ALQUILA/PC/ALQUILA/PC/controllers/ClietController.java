package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClietController {

    @Autowired
    IUserService entityService;


    @PostMapping("/api/Client/save")
    public UserEntity post(
             @RequestBody UserEntity entity) {

        entity.setRol(new RolEntity(2));
        return entityService.add(entity);
    }

    @GetMapping("/api/Client/all")

    public List<UserEntity> getAll() {
        return entityService.getAllByRol(2);
    }

    @GetMapping("/api/Client/{id}")
    public Optional<UserEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/api/Client/{id}")
    public UserEntity put(@RequestBody UserEntity entity,
                              @PathVariable("id") Integer id) {
        entity.setRol(new RolEntity(2));
        return entityService.update(entity);
    }

    @DeleteMapping("/api/Client/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
