package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;

import java.util.List;
import java.util.Optional;

public interface IReservationService {

    ReservationEntity add (ReservationEntity entity);
    Optional<ReservationEntity> getById (Integer id);

    List<ReservationEntity> getList();

    ReservationEntity update(ReservationEntity Reservation);

    void delete(Integer id);

    List<ReservationEntity> getListByClient(Integer clientId);
}


