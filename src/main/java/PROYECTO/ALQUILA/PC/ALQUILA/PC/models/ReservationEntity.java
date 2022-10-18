package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.ReservationStatus;


import javax.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "RESERVATION")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    @Column(nullable=false)
    private java.util.Date startDate =new Date();
    private java.util.Date devolutionDate;

     @Column(nullable=false)
    private ReservationStatus status=ReservationStatus.Programmed;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UserEntity client;

    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private ComputerEntity computer;

    @OneToMany()
    private List<ScoreEntity> score=new ArrayList<ScoreEntity>();

    public ReservationEntity() {
    }

    public ReservationEntity(int idReservation, Date devolution_date, Date start_date, ReservationStatus status, UserEntity client, ComputerEntity computer) {
        this.idReservation = idReservation;
        this.startDate = start_date;
        this.devolutionDate = devolution_date;
        this.status = status;
        this.client = client;
        this.computer = computer;
    }

    public ReservationEntity(int id) {
        this.idReservation = id;
    }


    public int getIdReservation() {

        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public java.util.Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(java.util.Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }


    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
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

    public List<ScoreEntity> getScore() {
        return score;
    }

    public void setScore(List<ScoreEntity> score) {
        this.score = score;
    }
}

