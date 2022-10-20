package PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ScoreEntity;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.util.ReservationStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class ReservationDto {
    private int idReservation;
    private Date startDate =new Date();
    private Date devolutionDate;

    private ReservationStatus status=ReservationStatus.Created;

    private Computer3Dto computer;
    private Client2Dto client;


    private List<ScoreEntity> score=new ArrayList<ScoreEntity>();


    public ReservationDto() {
    }

    public ReservationDto(int idReservation, Date startDate, Date devolutionDate, ReservationStatus status, Computer3Dto computer, Client2Dto client,  List<ScoreEntity> score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.computer = computer;
        this.client = client;
        this.score = score;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Computer3Dto getComputer() {
        return computer;
    }

    public void setComputer(Computer3Dto computer) {
        this.computer = computer;
    }

    public Client2Dto getClient() {
        return client;
    }

    public void setClient(Client2Dto client) {
        this.client = client;
    }

    public List<ScoreEntity> getScore() {
        return score;
    }

    public void setScore(List<ScoreEntity> score) {
        this.score = score;
    }

}

