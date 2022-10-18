package PROYECTO.ALQUILA.PC.ALQUILA.PC.repository;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<RolEntity, Integer> {
}
