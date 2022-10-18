package PROYECTO.ALQUILA.PC.ALQUILA.PC.repository;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Integer> {
    List<MessageEntity> findByClientId(Integer clientId);
}
