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


    @PostMapping("/Message")
    public MessageEntity post(
             @RequestBody MessageEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/Message")

    public List<MessageEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/Message/{id}")
    public Optional<MessageEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/Message/{id}")
    public MessageEntity put(@RequestBody MessageEntity entity,
                              @PathVariable("id") Integer id) {

        return entityService.update(entity);
    }

    @DeleteMapping("/Message/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
