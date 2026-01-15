package tech.codoverse;

public class SmsSender implements MessageSender {

    @Override
    public void sendMessage() {
        IO.println("Message is send with SMS.");
    }

}
