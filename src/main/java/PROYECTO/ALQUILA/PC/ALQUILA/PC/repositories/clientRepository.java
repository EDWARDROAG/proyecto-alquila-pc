package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;


import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

;
import java.util.List;
import java.util.Optional;

@Repository
public class clientRepository {
    @Autowired
    private clientCRUDRepository clientCRUDRepository;

    public List<client> getAll(){
        return (List<client>) clientCRUDRepository.findAll();


    }

    public Optional<client> getclient(int code){
        return clientCRUDRepository.findById(code);
    }

    public client save (client client){
        return clientCRUDRepository.save(client);
    }
}
