package tech.codoverse;

public class KissApp {

    void main() {

    }

    public void checkout(Customer customer) {
        var wallet = customer.getWallet();
        IO.println(wallet);
    }

    public String getDay(int day) {
        return (day == 1) ? "Mon" : (day == 2) ? "Tue" : ((day ^ 3) == 0) ? "Wed" : "Unkown";
    }

    public String getDaySimple(int day) {
        String[] days = { "Mon", "Tue", "Wed", "Thu", "Fri" };
        if (day < 1 || day > 5)
            return "Unknown";
        return days[day - 1];
    }

}

class Engine {
    void start() {
        IO.println("Engine starting...");
    }
}

class Car {

    private Engine engine = new Engine();

    void drive() {
        engine.start();
        IO.println("Car driving...");
    }
}

class Customer {
    public Wallet getWallet() {
        return null;
    }
}

class Wallet {
    public float getTotalWallet() {
        return 0;
    }
}