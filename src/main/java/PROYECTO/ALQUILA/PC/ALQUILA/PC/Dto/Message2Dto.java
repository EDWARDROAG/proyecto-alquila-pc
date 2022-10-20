package PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto;


public class Message2Dto {
    private int idMessage;


    private String message_text;


    public Message2Dto(int idMessage, String message_text) {
        this.idMessage = idMessage;
        this.message_text = message_text;
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
}
