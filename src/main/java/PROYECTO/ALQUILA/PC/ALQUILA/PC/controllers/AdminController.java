package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IUserService;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    IUserService entityService;


    @PostMapping("/api/Admin/save")
    public UserEntity post(
             @RequestBody UserEntity entity) {

        entity.setRol(new RolEntity(Roles.Admin.ordinal()));
        return entityService.add(entity);
    }

    @GetMapping("/api/Admin/all")

    public List<UserEntity> getAll() {
        return entityService.getAllByRol(Roles.Admin.ordinal());
    }

    @GetMapping("/api/Admin/{id}")
    public Optional<UserEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/api/Admin/update")
    public UserEntity put(@RequestBody UserEntity entity) {
        entity.setRol(new RolEntity(Roles.Admin.ordinal()));
        return entityService.update(entity);
    }

    @DeleteMapping("/api/Admin/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
