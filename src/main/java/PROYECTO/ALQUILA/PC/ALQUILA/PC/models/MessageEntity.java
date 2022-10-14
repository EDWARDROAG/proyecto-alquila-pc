package PROYECTO.ALQUILA.PC.ALQUILA.PC.models;
import org.apache.catalina.User;

import javax.persistence.*;


@Entity
@Table(name = "MESSAGE")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String message_text;

    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private ComputerEntity computer;

    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private UserEntity client;



    public MessageEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
