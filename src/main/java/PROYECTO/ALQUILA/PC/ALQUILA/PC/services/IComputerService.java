package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;
import java.util.List;
import java.util.Optional;


public interface IComputerService {

    ComputerEntity add (ComputerEntity entity);
    Optional<ComputerEntity> getById (Integer id);

    List<ComputerEntity> getList();

    ComputerEntity update(ComputerEntity Computer);

    void delete(Integer id);
}


