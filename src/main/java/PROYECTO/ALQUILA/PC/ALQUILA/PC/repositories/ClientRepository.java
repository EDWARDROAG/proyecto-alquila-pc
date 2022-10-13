package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCRUDRepository clientCRUDRepository;

    /**
     *
     * @return
     */
    public List<Client> getAll(){
        return (List<Client>) clientCRUDRepository.findAll();

    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Client> getClient(int id){
        return clientCRUDRepository.findById(id);
    }

    /**
     *
     * @param client
     * @return
     */
    public Client save (Client client){
        return clientCRUDRepository.save(client);
    }

    /**
     *
     * @param client
     */
    public void delete(Client client){
        clientCRUDRepository.delete(client);

    }
}
