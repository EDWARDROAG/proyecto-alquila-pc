package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    IReservationService entityService;




    @GetMapping("/api/Reservation/all")

    public List<ReservationEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Reservation/{id}")
    public Optional<ReservationEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }

    @PostMapping("/api/Reservation/save")
    public ResponseEntity<?> post(
            @RequestBody ReservationEntity entity) {

        ReservationEntity RestModel= entityService.add(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @PutMapping("/api/Reservation/update")
    public ResponseEntity<?> put(@RequestBody ReservationEntity entity) {

        ReservationEntity RestModel= entityService.update(entity);
        return  new ResponseEntity<>(RestModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/Reservation/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
