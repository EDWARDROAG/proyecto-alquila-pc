package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ComputerRepository {

    @Autowired
    private ComputerRepository computerCrudRepository;

    /**
     *
     * @return
     */
    public List<Computer> getAll(){
        return (List<Computer>) computerCrudRepository.findByAll();

    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Computer> getClient(int id){
        return computerCrudRepository.findById(id);
    }

    /**
     *
     * @param computer
     * @return
     */
    public Computer save (Computer computer){
        return computerCrudRepository.save(computer);
    }

    /**
     *
     * @param computer
     */
    public void delete(Computer computer){
        computerCrudRepository.delete(computer);

    }
}
