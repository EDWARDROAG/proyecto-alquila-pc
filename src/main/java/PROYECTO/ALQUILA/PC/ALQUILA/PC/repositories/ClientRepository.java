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

    public List<Client> getAll(){
        return (List<Client>) clientCRUDRepository.findAll();


    }

    public Optional<Client> getclient(int code){
        return clientCRUDRepository.findById(code);
    }

    public Client save (Client client){
        return clientCRUDRepository.save(client);
    }
}
