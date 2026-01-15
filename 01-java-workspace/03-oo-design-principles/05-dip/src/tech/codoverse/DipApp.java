package tech.codoverse;

public class DipApp {

    void main() {

        MessageSender sender = new EmailSender();
        NotificationService service = new NotificationService(sender);
        service.send();

    }

}