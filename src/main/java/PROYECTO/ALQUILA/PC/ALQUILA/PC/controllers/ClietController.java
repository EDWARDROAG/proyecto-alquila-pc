package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.ClientDto;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IMessageService;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IReservationService;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IUserService;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClietController {

    @Autowired
    IUserService entityService;

    @Autowired
    IMessageService messageService;

    @Autowired
    IReservationService reservationService;


    @GetMapping("/api/Client/all")

    public ResponseEntity<?> getAll() {
        try {
            List<UserEntity> list = entityService.getAllByRol(Roles.Client.ordinal());
            List<ClientDto> clients = new ArrayList<>();
            for (UserEntity user : list) {
                List<MessageEntity> messages = messageService.getListByClient(user.getId());
                List<ReservationEntity> reservations = reservationService.getListByClient(user.getId());
                ClientDto client = new ClientDto(user.getId(), user.getName(), user.getEmail(), user.getAge(), user.getPassword(), messages, reservations);
                clients.add(client);
            }


            return new ResponseEntity<>(clients, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/Client/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {

        //return entityService.getById(id);
        try {
            UserEntity user = entityService.getById(id).get();
            List<MessageEntity> messages = messageService.getListByClient(user.getId());
            List<ReservationEntity> reservations = reservationService.getListByClient(user.getId());
            ClientDto client = new ClientDto(user.getId(), user.getName(), user.getEmail(), user.getAge(), user.getPassword(), messages, reservations);


            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/Client/save")
    public ResponseEntity<?> post(
            @RequestBody ClientDto clientDto) {


        try {

            UserEntity user=new UserEntity(clientDto.getIdClient(),clientDto.getName(),clientDto.getEmail(),clientDto.getAge(),clientDto.getPassword(),new RolEntity(Roles.Client.ordinal()));
            UserEntity responseUser = entityService.add(user);
            clientDto.setIdClient(responseUser.getId());
            return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/Client/update")
    public ResponseEntity<?> put(@RequestBody ClientDto clientDto) {
        try {
            UserEntity user=new UserEntity(clientDto.getIdClient(),clientDto.getName(),clientDto.getEmail(),clientDto.getAge(),clientDto.getPassword(),new RolEntity(Roles.Client.ordinal()));
            UserEntity responseUser = entityService.update(user);
            clientDto.setIdClient(responseUser.getId());
            return new ResponseEntity<>(clientDto, HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("/api/Client/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            entityService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
