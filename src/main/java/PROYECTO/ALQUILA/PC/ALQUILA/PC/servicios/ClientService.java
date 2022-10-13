package PROYECTO.ALQUILA.PC.ALQUILA.PC.servicios;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Client;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id_client){
        return  clientRepository.getClient(id_client);
    }

    public Client insertClient(Client client){

    }

    public Client updateClient(Client client){

    }

    public Boolean deleteClient(int id_client){
        Boolean success = clientRepository.getClient(id_client).map(client -> {
        clientRepository.delete(client);
            return true;
        }).orElse(false);
        return success;

    }
}
