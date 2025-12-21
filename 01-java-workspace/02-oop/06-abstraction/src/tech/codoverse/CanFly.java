package tech.codoverse;

public interface CanFly {

    double MAX_SPEED = 10;

    void fly();

    public default void run() {
    }

    static double getSpeed() {
        return 0;
    }

}
