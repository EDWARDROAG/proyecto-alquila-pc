package PROYECTO.ALQUILA.PC.ALQUILA.PC.servicios;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Computer;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;


    public List<Computer> getAllComputer(){
        return computerRepository.getAll();
    }

    public Optional<Computer> getComputer(int id_computer){
        return  computerRepository.getComputer(id_computer);
    }

    public Computer insertComputer(Computer computer){

    }

    public Computer updateComputer(Computer computer){

    }

    public Boolean deleteComputer(int id_computer){
        Boolean success = computerRepository.getComputer(id_computer).map(computer -> {
            computerRepository.delete(computer);
            return true;
        }).orElse(false);
        return success;

    }
}


