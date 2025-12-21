package tech.codoverse.system.noti;

public class EmailNotificationFeature extends AbstractNotificationFeature {

    public EmailNotificationFeature() {
        super(1, "Send Email");
    }

    @Override
    public void send(String recipient, String message) {
        IO.println(">>> Connecting to SMTP Server...");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IO.println("Sent Email to [%s]: %s".formatted(recipient, message));
        IO.println("Status: Email Sent Successfully! \u2709\uFE0F");
    }

}
