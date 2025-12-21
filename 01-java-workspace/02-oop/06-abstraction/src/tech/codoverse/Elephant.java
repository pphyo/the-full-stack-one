package tech.codoverse;

public class Elephant extends Mammal {

    public Elephant(String type, String color) {
        super(type, color);
    }

    @Override
    public void makeSound() {
        IO.println("Elephant sounds.");
    }

}
