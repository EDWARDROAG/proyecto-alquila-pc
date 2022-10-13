package PROYECTO.ALQUILA.PC.ALQUILA.PC.servicios;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Client;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Score;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScore(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id_score){
        return  scoreRepository.getScore(id_score);
    }

    public Score insertScore(Score score){

    }

    public Score updateScore(Score score){

    }

    public Boolean deleteClient(int id_score){
        Boolean success = scoreRepository.getScore(id_score).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return success;

    }
}
