package tech.codoverse.system.noti;

import tech.codoverse.system.AbstractFeature;

public abstract class AbstractNotificationFeature extends AbstractFeature {

    public AbstractNotificationFeature(int id, String featureName) {
        super(id, featureName);
    }

    @Override
    public void doBusiness() {
        // print feautre name
        IO.println("--- " + getFeatureName() + " ----");

        IO.println();

        // get recipient name
        String recipient = getRecipient();

        IO.println();

        // get message
        String message = getMessage();

        IO.println();
        // send (do business)
        send(recipient, message);
        IO.println();
    }

    public abstract void send(String recipient, String message);

    private String getRecipient() {
        return IO.readln("Enter recipient name: ");
    }

    private String getMessage() {
        return IO.readln("Enter message content: ");
    }

}
