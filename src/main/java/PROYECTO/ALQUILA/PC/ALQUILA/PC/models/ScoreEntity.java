package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "SCORE")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private String message;

    @Min(1)
    @Max(5)
    private Integer score;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ReservationEntity reservation;

    public ScoreEntity() {
    }
    public ScoreEntity(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }
}

