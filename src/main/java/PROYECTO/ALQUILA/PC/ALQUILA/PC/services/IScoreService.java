package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ScoreEntity;

import java.util.List;
import java.util.Optional;

public interface IScoreService {

    ScoreEntity add (ScoreEntity entity);
    Optional<ScoreEntity> getById (Integer id);

    List<ScoreEntity> getList();

    ScoreEntity update(ScoreEntity Score);

    void delete(Integer id);
}


