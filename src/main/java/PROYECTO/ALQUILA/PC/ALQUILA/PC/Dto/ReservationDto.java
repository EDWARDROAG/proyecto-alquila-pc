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

    private ReservationStatus status=ReservationStatus.Programmed;

    private ComputerEntity computer;
    private ClientDto client;


    private List<ScoreEntity> score=new ArrayList<ScoreEntity>();

    public ReservationDto() {
    }

    public ReservationDto(int idReservation, Date devolutionDate, Date startDate, ReservationStatus status, ClientDto client, ComputerEntity computer, List<ScoreEntity> score) {
        this.idReservation = idReservation;
        this.devolutionDate = devolutionDate;
        this.startDate = startDate;
        this.status = status;
        this.client = client;
        this.computer = computer;
        this.score = score;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
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

