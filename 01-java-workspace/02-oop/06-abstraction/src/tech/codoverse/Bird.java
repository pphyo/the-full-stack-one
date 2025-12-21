package tech.codoverse;

public class Bird extends Animal implements CanFly {

    public Bird(String type, String color) {
        super(type, color);
    }

    @Override
    public void fly() {
    }

    @Override
    public void makeSound() {
    }

}
