package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    IUserService entityService;


    @PostMapping("/api/User/save")
    public UserEntity post(
             @RequestBody UserEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/api/User/all")

    public List<UserEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/User/{id}")
    public Optional<UserEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/api/User/update")
    public UserEntity put(@RequestBody UserEntity entity) {

        return entityService.update(entity);
    }

    @DeleteMapping("/api/User/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
