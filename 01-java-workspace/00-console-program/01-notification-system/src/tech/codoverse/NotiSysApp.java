package tech.codoverse;

import tech.codoverse.system.AbstractConsoleSystem;
import tech.codoverse.system.AbstractFeature;
import tech.codoverse.system.ConsoleCalculator;
import tech.codoverse.system.ConsoleNotification;
import tech.codoverse.system.SystemLauncher;
import tech.codoverse.system.calc.AdditionFeautre;
import tech.codoverse.system.calc.TakeawayFeature;
import tech.codoverse.system.noti.EmailNotificationFeature;
import tech.codoverse.system.noti.SmsNotificationFeature;

public class NotiSysApp {

    void main() {
        var calculatorSystem = new ConsoleCalculator("Smart Calculator",
                new AbstractFeature[] { new AdditionFeautre(), new TakeawayFeature() });

        var notificationSystem = new ConsoleNotification("Notify Pro",
                new AbstractFeature[] { new EmailNotificationFeature(), new SmsNotificationFeature() });

        var system = new SystemLauncher(new AbstractConsoleSystem[] { calculatorSystem, notificationSystem });
        system.startOS();
    }
}