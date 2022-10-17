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
public class AdminController {

    @Autowired
    IUserService entityService;

    @GetMapping("/api/Admin/all")
    public ResponseEntity<?> getAll() {
       try {
           List<UserEntity> list= entityService.getAllByRol(Roles.Admin.ordinal());
           return  new ResponseEntity<>(list, HttpStatus.OK);
       }catch (Exception ex){
           return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/api/Admin/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {

        try {
            Optional<UserEntity> entity= entityService.getById(id);
            return  new ResponseEntity<>(entity, HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/Admin/save")
    public ResponseEntity<?> post(
            @RequestBody UserEntity entity) {

        try {
            entity.setRol(new RolEntity(Roles.Admin.ordinal()));
            UserEntity RestModel= entityService.add(entity);
            return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping("/api/Admin/update")
    public ResponseEntity<?> put(@RequestBody UserEntity entity) {


        try {
            entity.setRol(new RolEntity(Roles.Admin.ordinal()));
            UserEntity RestModel= entityService.update(entity);
            return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/Admin/{id}")

    public ResponseEntity<?> delete(@PathVariable("id")Integer id) {
        try {
            entityService.delete(id);
            return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return  new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
