package PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto;


public class MessageDto {
    private int idMessage;


    private String messageText;
    private Computer2Dto computer;
    private Client2Dto client;




    public MessageDto(int idMessage, String message_text, Computer2Dto computer, Client2Dto client) {
        this.idMessage = idMessage;
        this.messageText = message_text;
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

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Computer2Dto getComputer() {
        return computer;
    }

    public void setComputer(Computer2Dto computer) {
        this.computer = computer;
    }

    public Client2Dto getClient() {
        return client;
    }

    public void setClient(Client2Dto client) {
        this.client = client;
    }
}
