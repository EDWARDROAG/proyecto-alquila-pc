package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCRUDRepository scoreCRUDRepository;

    /**
     *
     * @return
     */
    public List<Score> getAll(){
        return (List<Score>) scoreCRUDRepository.findAll();

    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Score> getClient(int id){
        return scoreCRUDRepository.findById(id);
    }

    /**
     *
     * @param score
     * @return
     */
    public Score save (Score score){
        return scoreCRUDRepository.save(score);
    }

    /**
     *
     * @param score
     */
    public void delete(Score score){
        scoreCRUDRepository.delete(score);

    }
}

