package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;

import javax.persistence.*;


@Entity
@Table(name = "MESSAGE")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String messageText;
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private UserEntity client;

    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private ComputerEntity computer;




    public MessageEntity() {
    }

    public MessageEntity(int idMessage, String message_text, ComputerEntity computer, UserEntity client) {
        this.id = idMessage;
        this.messageText = message_text;
        this.client = client;
        this.computer = computer;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
