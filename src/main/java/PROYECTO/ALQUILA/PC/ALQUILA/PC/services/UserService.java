package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.RolRepository;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository entityRepository;

    @Autowired
    RolRepository rolRepository;


    @Override
    public UserEntity add(UserEntity entity) {

        try {
            Optional<RolEntity> r = rolRepository.findById(entity.getRol().getId());

            if (!r.isPresent()) {
                throw new Exception("Rol is mandatory");
            }
            entity.setRol(r.get());
            entityRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<UserEntity> getById(Integer id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<UserEntity> getList() {
        return (List<UserEntity>) entityRepository.findAll();
    }

    @Override
    public List<UserEntity> getAllByRol(Integer rolId) {
        return (List<UserEntity>) entityRepository.findByRolId(rolId);
    }

    @Override
    public UserEntity update(UserEntity entity) {
        entityRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        entityRepository.deleteById(id);
    }
}
