package PROYECTO.ALQUILA.PC.ALQUILA.PC.controllers;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto.*;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.services.IMessageService;
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

    @Autowired
    IMessageService messageService;


    @GetMapping("/api/Reservation/all")

    public ResponseEntity<?> getAll() {
        try {
            List<ReservationEntity> list = entityService.getList();


            List<ReservationDto> reservationsDto = new ArrayList<>();

            for (ReservationEntity entity : list) {
                Client2Dto client = new Client2Dto(entity.getClient().getId(), entity.getClient().getName(),
                        entity.getClient().getEmail(), entity.getClient().getPassword(), entity.getClient().getAge());

                ComputerEntity computerItem = entity.getComputer();

                List<MessageEntity> messagesEntities = messageService.getListByClientAndComputer(entity.getClient().getId(), entity.getComputer().getId());

                List<Message2Dto> messages = new ArrayList<>();
                for (MessageEntity messageEntity : messagesEntities) {
                    Message2Dto newMessage = new Message2Dto(messageEntity.getId(), messageEntity.getMessageText());
                    messages.add(newMessage);
                }

                Computer3Dto computer = new Computer3Dto(computerItem.getId(), computerItem.getName(), computerItem.getBrand(), computerItem.getYear(),
                        computerItem.getDescription(), new CategoryDto(computerItem.getCategory().getId(), computerItem.getCategory().getName(), computerItem.getCategory().getDescription()), messages);

                ReservationDto reservationDto = new ReservationDto(entity.getIdReservation(), entity.getDevolutionDate(), entity.getStartDate(), entity.getStatus(), computer, client, null);
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

            Client2Dto client = new Client2Dto(entity.getClient().getId(), entity.getClient().getName(),
                    entity.getClient().getEmail(), entity.getClient().getPassword(), entity.getClient().getAge());

            ComputerEntity computerItem = entity.getComputer();

            List<MessageEntity> messagesEntities = messageService.getListByClientAndComputer(entity.getClient().getId(), entity.getComputer().getId());

            List<Message2Dto> messages = new ArrayList<>();
            for (MessageEntity messageEntity : messagesEntities) {
                Message2Dto newMessage = new Message2Dto(messageEntity.getId(), messageEntity.getMessageText());
                messages.add(newMessage);
            }

            Computer3Dto computer = new Computer3Dto(computerItem.getId(), computerItem.getName(), computerItem.getBrand(), computerItem.getYear(),
                    computerItem.getDescription(), new CategoryDto(computerItem.getCategory().getId(), computerItem.getCategory().getName(), computerItem.getCategory().getDescription()), messages);

            ReservationDto reservationDto = new ReservationDto(entity.getIdReservation(), entity.getDevolutionDate(), entity.getStartDate(), entity.getStatus(), computer, client, null);


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
                    entityDto.getStatus(), user, new ComputerEntity(entityDto.getComputer().getId()));

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

            ReservationEntity entity = new ReservationEntity(entityDto.getIdReservation(), entityDto.getDevolutionDate(), entityDto.getStartDate(), entityDto.getStatus(), user,new ComputerEntity(entityDto.getComputer().getId()));
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
