package tech.codoverse.system;

import static tech.codoverse.utils.AppUtils.*;

public class ConsoleNotification extends AbstractConsoleSystem {

    public ConsoleNotification(String appName, AbstractFeature[] features) {
        super(appName, features);
    }

    @Override
    public void launch() {
        showMessage(getAppName());

        do {
            IO.println();

            IO.println("Select notification channel: ");
            // show menus and get selected feature
            AbstractFeature feature = getSelectedFeature();

            IO.println();

            // do business
            feature.doBusiness();

            // ask restart

        } while (askToContinue());

        IO.println();

        showMessage("Bye Bye");
    }

}
