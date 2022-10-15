package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "RESERVATION")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String devolution_date;
    private String start_date;

    private String status;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UserEntity client;

    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private ComputerEntity computer;

    public ReservationEntity() {
    }
    

    public ReservationEntity(int id) {
        this.id = id;
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

    public UserEntity getClient() {
        return client;
    }

    public void setClient(UserEntity client) {
        this.client = client;
    }

    public ComputerEntity getComputer() {
        return computer;
    }

    public void setComputer(ComputerEntity computer) {
        this.computer = computer;
    }
}

