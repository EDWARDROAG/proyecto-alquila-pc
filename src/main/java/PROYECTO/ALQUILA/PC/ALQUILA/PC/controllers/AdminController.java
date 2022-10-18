package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.AdminDto;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.AdminDto;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IUserService;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    IUserService entityService;

    @GetMapping("/api/Admin/all")

    public ResponseEntity<?> getAll() {
        try {
            List<UserEntity> list = entityService.getAllByRol(Roles.Client.ordinal());
            List<AdminDto> clients = new ArrayList<>();
            for (UserEntity user : list) {

                AdminDto client = new AdminDto(user.getId(), user.getName(), user.getEmail(), user.getAge(), user.getPassword());
                clients.add(client);
            }


            return new ResponseEntity<>(clients, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/Admin/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {

        //return entityService.getById(id);
        try {
            UserEntity user = entityService.getById(id).get();
            AdminDto client = new AdminDto(user.getId(), user.getName(), user.getEmail(), user.getAge(), user.getPassword());


            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/Admin/save")
    public ResponseEntity<?> post(
            @RequestBody AdminDto AdminDto) {


        try {

            UserEntity user=new UserEntity(AdminDto.getIdAdmin(),AdminDto.getName(),AdminDto.getEmail(),AdminDto.getAge(),AdminDto.getPassword(),new RolEntity(Roles.Client.ordinal()));
            UserEntity responseUser = entityService.add(user);
            AdminDto.setIdAdmin(responseUser.getId());
            return new ResponseEntity<>(AdminDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/Admin/update")
    public ResponseEntity<?> put(@RequestBody AdminDto AdminDto) {
        try {
            UserEntity user=new UserEntity(AdminDto.getIdAdmin(),AdminDto.getName(),AdminDto.getEmail(),AdminDto.getAge(),AdminDto.getPassword(),new RolEntity(Roles.Client.ordinal()));
            UserEntity responseUser = entityService.update(user);
            AdminDto.setIdAdmin(responseUser.getId());
            return new ResponseEntity<>(AdminDto, HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("/api/Admin/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            entityService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
