package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    IReservationService entityService;


    @PostMapping("/Reservation")
    public ReservationEntity post(
             @RequestBody ReservationEntity entity) {
        return entityService.add(entity);
    }

    @GetMapping("/Reservation")

    public List<ReservationEntity> getAll() {
        return entityService.getList();
    }

    @GetMapping("/Reservation/{id}")
    public Optional<ReservationEntity> getById(@PathVariable("id") Integer id) {
        return entityService.getById(id);
    }


    @PutMapping("/Reservation/{id}")
    public ReservationEntity put(@RequestBody ReservationEntity entity,
                              @PathVariable("id") Integer id) {

        return entityService.update(entity);
    }

    @DeleteMapping("/Reservation/{id}")

    public String delete(@PathVariable("id")Integer id) {
        entityService.delete(id);
        return "Deleted Successfully";
    }
}
