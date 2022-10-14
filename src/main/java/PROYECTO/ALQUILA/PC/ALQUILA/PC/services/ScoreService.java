package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ScoreEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ScoreService implements IScoreService {

    @Autowired
    ScoreRepository entityRepository;


    @Override
    public ScoreEntity add(ScoreEntity entity) {
        entityRepository.save(entity);
        return entity;

    }

    @Override
    public Optional<ScoreEntity> getById(Integer id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<ScoreEntity> getList() {
        return (List<ScoreEntity>) entityRepository.findAll();
    }

    @Override
    public ScoreEntity update(ScoreEntity entity) {
        entityRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        entityRepository.deleteById(id);
    }
}
