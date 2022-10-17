package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    IMessageService entityService;




    @GetMapping("/api/Message/all")

    public List<MessageEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Message/{id}")
    public Optional<MessageEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }

    @PostMapping("/api/Message/save")
    public ResponseEntity<?> post(
            @RequestBody MessageEntity entity) {

        MessageEntity RestModel= entityService.add(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }
    @PutMapping("/api/Message/update")
    public ResponseEntity<?> put(@RequestBody MessageEntity entity) {

        MessageEntity RestModel= entityService.update(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/Message/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
