package PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;

import java.util.ArrayList;
import java.util.List;


public class ClientDto {

    private int idClient;


    private String name;


    private String email;
    private String password;
    private Integer age;






    private List<MessageEntity> messages=new ArrayList<MessageEntity>();


    private List<ReservationEntity> reservations=new ArrayList<ReservationEntity>();

    public ClientDto() {
    }

    public ClientDto(int idClient, String name, String email, Integer age, String password, List<MessageEntity> messages, List<ReservationEntity> reservations) {
        this.idClient = idClient;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.messages = messages;
        this.reservations = reservations;
    }

    public ClientDto(int idClient, String name, String email, Integer age, String password) {
        this.idClient = idClient;
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public ClientDto(int idClient) {
        this.idClient = idClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }
}
