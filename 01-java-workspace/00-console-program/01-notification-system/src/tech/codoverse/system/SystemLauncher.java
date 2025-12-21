package tech.codoverse.system;

import static tech.codoverse.utils.AppUtils.showMessage;

public class SystemLauncher {

    private AbstractConsoleSystem[] systems;

    public SystemLauncher(AbstractConsoleSystem[] systems) {
        this.systems = systems;
    }

    public void startOS() {
        showMessage("Welcome to Codoverse System");

        while (true) {
            IO.println("\nSelect a System: ");

            for (int i = 0; i < systems.length; i++) {
                IO.println("%d. %s".formatted(i + 1, systems[i].getAppName()));
            }

            int choice = Integer.parseInt(IO.readln("\nOpen System ID: "));

            if (choice == systems.length + 1) {
                IO.println("\nShutting down... Goodbye!");
                break;
            }

            if (choice > 0 && choice <= systems.length) {
                AbstractConsoleSystem system = systems[choice - 1];

                IO.println("\n>>> Launching " + system.getAppName());

                system.launch();

                IO.println("\n>>> Closed " + system.getAppName());
            } else {
                IO.println("Invalid System ID!");
            }
        }
    }

}
