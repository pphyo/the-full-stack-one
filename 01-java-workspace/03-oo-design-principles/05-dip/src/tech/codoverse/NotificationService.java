package tech.codoverse;

public class NotificationService {

    private MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void send() {
        sender.sendMessage();
    }

}
