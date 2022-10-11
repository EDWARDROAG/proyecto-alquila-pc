package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerRepository {
    @Autowired
    private ComputerCRUDRepository computerCRUDRepository;
}
