package tech.codoverse;

public class Lion extends Mammal {

    @Override
    public void makeSound() {
        IO.println("Lion roars...");
    }

    public void run() {
        IO.println("Lion runs...");
    }

    public int age() {
        return 5;
    }

}
