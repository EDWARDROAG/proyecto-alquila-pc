package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ComputerService implements IComputerService {

    @Autowired
    ComputerRepository entityRepository;


    @Override
    public ComputerEntity add(ComputerEntity entity) {
        entityRepository.save(entity);
        return entity;

    }

    @Override
    public Optional<ComputerEntity> getById(Integer id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<ComputerEntity> getList() {
        return (List<ComputerEntity>) entityRepository.findAll();
    }

    @Override
    public ComputerEntity update(ComputerEntity entity) {
        entityRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        entityRepository.deleteById(id);
    }
}
