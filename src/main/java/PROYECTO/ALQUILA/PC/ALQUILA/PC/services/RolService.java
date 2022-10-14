package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RolService implements IRolService {

    @Autowired
    RolRepository entityRepository;


    @Override
    public RolEntity add(RolEntity entity) {
        entityRepository.save(entity);
        return entity;

    }

    @Override
    public Optional<RolEntity> getById(Integer id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<RolEntity> getList() {
        return (List<RolEntity>) entityRepository.findAll();
    }

    @Override
    public RolEntity update(RolEntity entity) {
        entityRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        entityRepository.deleteById(id);
    }
}
