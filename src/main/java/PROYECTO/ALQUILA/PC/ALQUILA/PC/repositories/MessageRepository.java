package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Client;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCRUDRepository messageCRUDRepository;

    /**
     *
     * @return
     */
    public List<Message> getAll(){
        return (List<Message>) messageCRUDRepository.findAll();

    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Message> getClient(int id){
        return messageCRUDRepository.findById(id);
    }

    /**
     *
     * @param message
     * @return
     */
    public Message save (Message message){
        return messageCRUDRepository.save(message);
    }

    /**
     *
     * @param message
     */
    public void delete(Message message){
        messageCRUDRepository.delete(message);

    }
}
