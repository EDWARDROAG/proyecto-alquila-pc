package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.ReservationStatus;
import org.springframework.lang.Nullable;

import javax.persistence.*;


import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "RESERVATION")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private java.sql.Date devolution_date;

    @Column(nullable=false)
    private java.sql.Date start_date=new Date(System.currentTimeMillis());

    @Column(nullable=false)
    private ReservationStatus status=ReservationStatus.Programmed;


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

    public java.sql.Date getDevolution_date() {
        return devolution_date;
    }

    public void setDevolution_date(java.sql.Date devolution_date) {
        this.devolution_date = devolution_date;
    }


    public java.sql.Date getStart_date() {
        return start_date;
    }

    public void setStart_date(java.sql.Date start_date) {
        this.start_date = start_date;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
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

