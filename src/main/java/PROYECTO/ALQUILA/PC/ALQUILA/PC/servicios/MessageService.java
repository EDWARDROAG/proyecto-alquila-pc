package PROYECTO.ALQUILA.PC.ALQUILA.PC.servicios;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Message;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    public List<Message> getAllMessage(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id_message){
        return  messageRepository.getMessage(id_message);
    }

    public Message insertMessage(Message message){
        if(message.getId_message() == null){
            }
        else
            return message;
    }

    public Message updateMessage(Message message){

    }

    public Boolean deleteMessage(int id_message){
        Boolean success = messageRepository.getMessage(id_message).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return success;

    }
}
