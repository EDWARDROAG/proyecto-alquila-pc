package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IUserService;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    IUserService entityService;



    @GetMapping("/api/User/all")

    public List<UserEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/User/{id}")
    public Optional<UserEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }

    @PostMapping("/api/User/save")
    public ResponseEntity<?> post(
            @RequestBody UserEntity entity) {

        UserEntity RestModel= entityService.add(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @PutMapping("/api/User/update")
    public ResponseEntity<?> put(@RequestBody UserEntity entity) {

        UserEntity RestModel= entityService.update(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/User/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
