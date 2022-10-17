package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ScoreEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ScoreController {

    @Autowired
    IScoreService entityService;




    @GetMapping("/api/Score/all")

    public List<ScoreEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Score/{id}")
    public Optional<ScoreEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }

    @PostMapping("/api/Score/save")
    public ResponseEntity<?> post(
            @RequestBody ScoreEntity entity) throws Exception {
        if(entity.getScore()>5 || entity.getScore()<1){
            throw new Exception("el score es invalido");
        }
        ScoreEntity RestModel= entityService.add(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @PutMapping("/api/Score/update")
    public  ResponseEntity<?> put(@RequestBody ScoreEntity entity) throws Exception {
        if(entity.getScore()>5 || entity.getScore()<1){
            throw new Exception("el score es invalido");
        }
        ScoreEntity RestModel= entityService.update(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/Score/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
