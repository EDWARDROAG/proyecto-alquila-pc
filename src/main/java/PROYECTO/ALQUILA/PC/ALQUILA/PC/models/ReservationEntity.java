package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;
import javax.persistence.*;


@Entity
@Table(name = "RESERVATION")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String devolution_date;
    private String start_date;

    private String status;


    public ReservationEntity() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevolution_date() {
        return devolution_date;
    }

    public void setDevolution_date(String devolution_date) {
        this.devolution_date = devolution_date;
    }


    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

