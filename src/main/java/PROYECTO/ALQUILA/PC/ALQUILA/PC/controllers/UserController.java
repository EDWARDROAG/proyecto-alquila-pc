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


    @PostMapping("/User")
    public UserEntity post(
             @RequestBody UserEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/User")

    public List<UserEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/User/{id}")
    public Optional<UserEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/User/{id}")
    public UserEntity put(@RequestBody UserEntity entity,
                              @PathVariable("id") Integer id) {

        return entityService.update(entity);
    }

    @DeleteMapping("/User/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}