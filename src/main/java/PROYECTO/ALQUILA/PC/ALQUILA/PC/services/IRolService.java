package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;

import java.util.List;
import java.util.Optional;

public interface IRolService {

    RolEntity add (RolEntity entity);
    Optional<RolEntity> getById (Integer id);

    List<RolEntity> getList();

    RolEntity update(RolEntity Rol);

    void delete(Integer id);
}


