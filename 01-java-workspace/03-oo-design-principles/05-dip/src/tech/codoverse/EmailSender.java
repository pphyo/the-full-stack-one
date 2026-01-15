package tech.codoverse;

public class EmailSender implements MessageSender {

    @Override
    public void sendMessage() {
        IO.println("Message is sent with Email.");
    }

}
