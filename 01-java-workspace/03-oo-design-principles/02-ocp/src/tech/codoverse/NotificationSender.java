package tech.codoverse;

// violating ocp
public class NotificationSender {

    public void send(String type) {
        if (type.equals("email")) {

        } else if (type.equals("sms")) {

        } else if (type.equals("push")) {

        }
    }

}
