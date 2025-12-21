package tech.codoverse;

public class AbstractionApp {

    void main() {
        // anonymous inner class
        // high encapsulation
        Animal ani = new Animal("Reptile", "Black") {
            @Override
            public void makeSound() {
                IO.println("...generic sound...");
            }
        };

        ani.makeSound();

        Animal ele = new Elephant("Reptile", "Brick");
        ele.makeSound();

    }

}