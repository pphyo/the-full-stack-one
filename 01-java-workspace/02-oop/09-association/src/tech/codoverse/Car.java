package tech.codoverse;

public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void move() {
        engine.start();
    }

}
