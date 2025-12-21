package tech.codoverse.system.noti;

import java.time.Duration;

public class SmsNotificationFeature extends AbstractNotificationFeature {

    public SmsNotificationFeature() {
        super(2, "Send SMS");
    }

    @Override
    public void send(String recipient, String message) {
        IO.println(">>> Connection to GSM Network...");
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IO.println("Send SMS to [%s]: %s".formatted(recipient, message));
        IO.println("Status: SMS Sent Successfully! 💬");
    }

}
