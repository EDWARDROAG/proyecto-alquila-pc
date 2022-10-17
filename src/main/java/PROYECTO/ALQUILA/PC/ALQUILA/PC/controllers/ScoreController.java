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


    @PostMapping("/api/Score/save")
    public ScoreEntity post(
             @RequestBody ScoreEntity entity) throws Exception {
        if(entity.getScore()>5 || entity.getScore()<1){
            throw new Exception("el score es invalido");
        }
        return entityService.add(entity);
    }

    @GetMapping("/api/Score/all")

    public List<ScoreEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Score/{id}")
    public Optional<ScoreEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/api/Score/update")
    public ScoreEntity put(@RequestBody ScoreEntity entity) throws Exception {
        if(entity.getScore()>5 || entity.getScore()<1){
            throw new Exception("el score es invalido");
        }
        return entityService.update(entity);
    }

    @DeleteMapping("/api/Score/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
