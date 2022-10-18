package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.MessageRepository;
import java.util.List;
import java.util.Optional;

public interface IMessageService {

    MessageEntity add (MessageEntity entity);
    Optional<MessageEntity> getById (Integer id);

    List<MessageEntity> getList();
    List<MessageEntity> getListByClient(Integer clientId);

    MessageEntity update(MessageEntity Message);

    void delete(Integer id);
}


