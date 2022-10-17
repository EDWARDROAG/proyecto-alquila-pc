package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    UserEntity add (UserEntity entity);
    Optional<UserEntity> getById (Integer id);

    List<UserEntity> getList();
    List<UserEntity> getAllByRol(Integer rolId);

    UserEntity update(UserEntity User);

    void delete(Integer id);
}


