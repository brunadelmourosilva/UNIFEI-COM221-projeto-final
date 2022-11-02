package br.unifei.imc.lojaprodutosconsumer.messages;


public class FinishOrderMessage {

    private String message;

    public FinishOrderMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FinishOrderMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
