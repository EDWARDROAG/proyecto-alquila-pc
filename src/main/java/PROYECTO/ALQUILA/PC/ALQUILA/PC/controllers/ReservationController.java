package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IReservationService;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.ReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    IReservationService entityService;


    @PostMapping("/api/Reservation/save")
    public ReservationEntity post(
             @RequestBody ReservationEntity entity) {

        return entityService.add(entity);
    }

    @GetMapping("/api/Reservation/all")

    public List<ReservationEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/api/Reservation/{id}")
    public Optional<ReservationEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/api/Reservation/{id}")
    public ReservationEntity put(@RequestBody ReservationEntity entity,
                              @PathVariable("id") Integer id) {

        return entityService.update(entity);
    }

    @DeleteMapping("/api/Reservation/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
