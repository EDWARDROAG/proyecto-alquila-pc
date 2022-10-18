package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;

import javax.persistence.*;


@Entity
@Table(name = "MESSAGE")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;


    private String message_text;
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private UserEntity client;

    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private ComputerEntity computer;




    public MessageEntity() {
    }

    public MessageEntity(int idMessage, String message_text, ComputerEntity computer, UserEntity client) {
        this.idMessage = idMessage;
        this.message_text = message_text;
        this.client = client;
        this.computer = computer;

    }

    public MessageEntity(int id) {
        this.idMessage = id;
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

    public UserEntity getClient() {
        return client;
    }

    public void setClient(UserEntity client) {
        this.client = client;
    }
}
