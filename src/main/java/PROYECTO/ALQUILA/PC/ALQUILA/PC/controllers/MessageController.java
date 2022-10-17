package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    IMessageService entityService;


    @PostMapping("/api/Message/save")
    public MessageEntity post(
             @RequestBody MessageEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/api/Message/all")

    public List<MessageEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Message/{id}")
    public Optional<MessageEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/api/Message/update")
    public MessageEntity put(@RequestBody MessageEntity entity) {

        return entityService.update(entity);
    }

    @DeleteMapping("/api/Message/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
