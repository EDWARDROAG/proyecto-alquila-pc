package PROYECTO.ALQUILA.PC.ALQUILA.PC.repository;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Integer> {
    List<ReservationEntity> findByClientId(Integer clientId);
}
