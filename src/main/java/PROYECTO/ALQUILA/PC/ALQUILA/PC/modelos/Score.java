package PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
@Table(name = "SCORE")

public class Score implements Serializable {
    @Id
    private Integer id_score;
    private String message;
    private Integer score;

    private Reservation reservation_fk;

    /**
     *
     * @param id_score
     * @param message
     * @param score
     */
    public Score(Integer id_score, String message, Integer score){
        this.setId_score(id_score);
        this.setScore(score);
        this.setMessage(message);
    }

    public Integer getId_score() {
        return id_score;
    }

    public void setId_score(Integer id_score) {
        this.id_score = id_score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

