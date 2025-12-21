package tech.codoverse.utils;

public class AppUtils {

    public static void showMessage(String message) {
        var symbol = new StringBuilder();

        for (int i = 0, l = message.length(); i < l; i++) {
            symbol.append("*");
        }

        IO.println("**" + symbol.toString() + "**");
        IO.println("* " + message + " *");
        IO.println("**" + symbol.toString() + "**");
    }

    public static boolean askToContinue() {
        var answer = IO.readln("Send another notification? (y/n): ");
        return answer.equalsIgnoreCase("y");
    }

}
