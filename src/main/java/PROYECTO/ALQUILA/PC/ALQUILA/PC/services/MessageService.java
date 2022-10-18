package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MessageService implements IMessageService {

    @Autowired
    MessageRepository entityRepository;


    @Override
    public MessageEntity add(MessageEntity entity) {
        entityRepository.save(entity);
        return entity;

    }

    @Override
    public Optional<MessageEntity> getById(Integer id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<MessageEntity> getList() {
        return (List<MessageEntity>) entityRepository.findAll();
    }

    @Override
    public List<MessageEntity> getListByClient(Integer clientId) {
        return (List<MessageEntity>) entityRepository.findByClientId(clientId);
    }

    @Override
    public MessageEntity update(MessageEntity entity) {
        entityRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        entityRepository.deleteById(id);
    }
}
