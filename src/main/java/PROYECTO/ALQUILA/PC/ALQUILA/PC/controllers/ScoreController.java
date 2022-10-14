package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ScoreEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ScoreController {

    @Autowired
    IScoreService entityService;


    @PostMapping("/Score")
    public ScoreEntity post(
             @RequestBody ScoreEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/Score")

    public List<ScoreEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/Score/{id}")
    public Optional<ScoreEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/Score/{id}")
    public ScoreEntity put(@RequestBody ScoreEntity entity,
                              @PathVariable("id") Integer id) {

        return entityService.update(entity);
    }

    @DeleteMapping("/Score/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
