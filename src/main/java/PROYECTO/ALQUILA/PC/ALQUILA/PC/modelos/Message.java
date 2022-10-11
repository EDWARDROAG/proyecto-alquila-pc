package PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "message")

public class Message implements Serializable {
    @Id
    private Integer id_message;
    private String message_text;

    private client client_fk;

    private client computer_fk;

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("message")
    private Category client;

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("message")
    private Category computer;

    /**

     * @param id_message
     * @param message_text
     */
    public Message(Integer id_message, String message_text){
        this.setId_message(id_message);
        this.setMessage_text(message_text);
    }

    public Integer getId_message() {
        return id_message;
    }

    public void setId_message(Integer id_message) {
        this.id_message = id_message;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.client getClient_fk() {
        return client_fk;
    }

    public void setClient_fk(PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.client client_fk) {
        this.client_fk = client_fk;
    }

    public PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.client getComputer_fk() {
        return computer_fk;
    }

    public void setComputer_fk(PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.client computer_fk) {
        this.computer_fk = computer_fk;
    }

    public Category getClient() {
        return client;
    }

    public void setClient(Category client) {
        this.client = client;
    }

    public Category getComputer() {
        return computer;
    }

    public void setComputer(Category computer) {
        this.computer = computer;
    }
}
