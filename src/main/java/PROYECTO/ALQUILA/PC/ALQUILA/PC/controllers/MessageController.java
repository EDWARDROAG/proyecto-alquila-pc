package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.ClientDto;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.MessageDto;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IMessageService;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    IMessageService entityService;


    @GetMapping("/api/Message/all")

    public ResponseEntity<?> getAll() {
        try {
            List<MessageEntity> list = entityService.getList();
            List<MessageDto> messages = new ArrayList<>();

            for (MessageEntity message : list) {
                ClientDto client = new ClientDto(message.getClient().getId(), message.getClient().getName(), message.getClient().getEmail(), message.getClient().getAge(), message.getClient().getPassword());
                MessageDto meesageDto = new MessageDto(message.getIdMessage(), message.getMessage_text(), message.getComputer(), client);
                messages.add(meesageDto);
            }

            return new ResponseEntity<>(messages, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/Message/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {

        try {
            MessageEntity message = entityService.getById(id).get();

            ClientDto client = new ClientDto(message.getClient().getId(), message.getClient().getName(), message.getClient().getEmail(), message.getClient().getAge(), message.getClient().getPassword());
            MessageDto meesageDto = new MessageDto(message.getIdMessage(), message.getMessage_text(), message.getComputer(), client);

            return new ResponseEntity<>(meesageDto, HttpStatus.OK);


        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/Message/save")
    public ResponseEntity<?> post(
            @RequestBody MessageDto entityDto) {
        try {

            UserEntity user = new UserEntity(entityDto.getClient().getIdClient());
            MessageEntity entity = new MessageEntity(entityDto.getIdMessage(), entityDto.getMessage_text(), entityDto.getComputer(), user);
            entity = entityService.add(entity);
            entityDto.setIdMessage(entity.getIdMessage());
            return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/api/Message/update")
    public ResponseEntity<?> put(@RequestBody MessageDto entityDto) {
        try {
            UserEntity user = new UserEntity(entityDto.getClient().getIdClient());
            MessageEntity entity = new MessageEntity(entityDto.getIdMessage(), entityDto.getMessage_text(), entityDto.getComputer(), user);
            entity = entityService.update(entity);
            entityDto.setIdMessage(entity.getIdMessage());
            return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/api/Message/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            entityService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
