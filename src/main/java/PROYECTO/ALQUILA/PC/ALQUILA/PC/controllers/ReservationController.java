package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.ClientDto;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.ReservationDto;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    IReservationService entityService;


    @GetMapping("/api/Reservation/all")

    public ResponseEntity<?> getAll() {
        try {
            List<ReservationEntity> list = entityService.getList();


            List<ReservationDto> reservationsDto = new ArrayList<>();

            for (ReservationEntity entity : list) {
                ClientDto client = new ClientDto(entity.getClient().getId(), entity.getClient().getName(), entity.getClient().getEmail(), entity.getClient().getAge(), entity.getClient().getPassword());
                ReservationDto reservationDto = new ReservationDto(entity.getIdReservation(), entity.getDevolutionDate(), entity.getStartDate(), entity.getStatus(), client, entity.getComputer(), null);
                reservationsDto.add(reservationDto);
            }

            return new ResponseEntity<>(reservationsDto, HttpStatus.OK);


        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/Reservation/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {

        try {
            ReservationEntity entity = entityService.getById(id).get();
            ClientDto client = new ClientDto(entity.getClient().getId(), entity.getClient().getName(), entity.getClient().getEmail(), entity.getClient().getAge(), entity.getClient().getPassword());
            ReservationDto reservationDto = new ReservationDto(entity.getIdReservation(), entity.getDevolutionDate(), entity.getStartDate(), entity.getStatus(), client, entity.getComputer(), null);

            return new ResponseEntity<>(reservationDto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/Reservation/save")
    public ResponseEntity<?> post(
            @RequestBody ReservationDto entityDto) {
        try {
            UserEntity user = new UserEntity(entityDto.getClient().getIdClient());

            ReservationEntity entity = new ReservationEntity(entityDto.getIdReservation(),
                    entityDto.getDevolutionDate(),
                    entityDto.getStartDate(),
                    entityDto.getStatus(), user, entityDto.getComputer());

            entity = entityService.add(entity);
            entityDto.setIdReservation(entity.getIdReservation());
            return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/api/Reservation/update")
    public ResponseEntity<?> put(@RequestBody ReservationDto entityDto) {
        try {
            UserEntity user = new UserEntity(entityDto.getClient().getIdClient());

            ReservationEntity entity = new ReservationEntity(entityDto.getIdReservation(), entityDto.getDevolutionDate(), entityDto.getStartDate(), entityDto.getStatus(), user, entityDto.getComputer());
            entity = entityService.update(entity);
            entityDto.setIdReservation(entity.getIdReservation());
            return new ResponseEntity<>(entityDto, HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/api/Reservation/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            entityService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
