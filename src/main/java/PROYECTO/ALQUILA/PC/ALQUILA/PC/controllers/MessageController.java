package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.*;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.*;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
                Client2Dto client = new Client2Dto(message.getClient().getId(), message.getClient().getName(), message.getClient().getEmail(), message.getClient().getPassword(), message.getClient().getAge());

                ComputerEntity computerItem=message.getComputer();

                Computer2Dto newComputer2Dto=new Computer2Dto(computerItem.getId(),computerItem.getName(),computerItem.getBrand(),computerItem.getYear(),
                        computerItem.getDescription(),new CategoryDto(computerItem.getCategory().getId(),computerItem.getCategory().getName(),computerItem.getCategory().getDescription()));

                MessageDto messageDto = new MessageDto(message.getId(), message.getMessageText(), newComputer2Dto, client);
                messages.add(messageDto);
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

            Client2Dto client = new Client2Dto(message.getClient().getId(), message.getClient().getName(), message.getClient().getEmail(),  message.getClient().getPassword(),message.getClient().getAge());
                ComputerEntity computerItem=message.getComputer();

            Computer2Dto newComputer2Dto=new Computer2Dto(computerItem.getId(),computerItem.getName(),computerItem.getBrand(),computerItem.getYear(),
                    computerItem.getDescription(),new CategoryDto(computerItem.getCategory().getId(),computerItem.getCategory().getName(),computerItem.getCategory().getDescription()));


            MessageDto meesageDto = new MessageDto(message.getId(), message.getMessageText(),newComputer2Dto, client);

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


            MessageEntity entity = new MessageEntity(entityDto.getIdMessage(), entityDto.getMessageText(), new ComputerEntity(entityDto.getComputer().getId()), user);
            entity = entityService.add(entity);
            entityDto.setIdMessage(entity.getId());
            return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/api/Message/update")
    public ResponseEntity<?> put(@RequestBody MessageDto entityDto) {
        try {
            UserEntity user = new UserEntity(entityDto.getClient().getIdClient());
            MessageEntity entity = new MessageEntity(entityDto.getIdMessage(), entityDto.getMessageText(), new ComputerEntity(entityDto.getComputer().getId()), user);
            entity = entityService.update(entity);
            entityDto.setIdMessage(entity.getId());
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
