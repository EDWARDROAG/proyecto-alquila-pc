package PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.UserEntity;

import javax.persistence.*;


public class MessageDto {
    private int idMessage;


    private String message_text;
    private ClientDto client;
    private ComputerEntity computer;




    public MessageDto(int idMessage, String message_text, ComputerEntity computer, ClientDto client) {
        this.idMessage = idMessage;
        this.message_text = message_text;
        this.client = client;
        this.computer = computer;

    }

    public MessageDto() {
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public ComputerEntity getComputer() {
        return computer;
    }

    public void setComputer(ComputerEntity computer) {
        this.computer = computer;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
