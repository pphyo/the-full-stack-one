package tech.codoverse;

public class MethodOverridingApp {

    void main() {

        IO.println("Program started...");

        Animal ani = new Mammal(); // the actual object // implicit cast or up cast
        // ((Lion) ani).run();

        if (ani instanceof Lion lion && lion.age() > 0) {
            // Lion lion = (Lion) ani; // target type
            lion.run();
        } else {
            ani.makeSound();
        }

        IO.println("Tiger: " + (ani instanceof Tiger));
        IO.println("Lion: " + (ani instanceof Lion));
        IO.println("Mammal: " + (ani instanceof Mammal));
        IO.println("Animal: " + (ani instanceof Animal));

        IO.println("Terminated...");

    }

    void choice(int choice) {
        switch (choice) {
            case 1:
                touch(new Lion());
                break;
            case 2:
                touch(new Tiger());
                break;
            case 3:
                touch(new Bird());
        }
    }

    void touch(Animal ani) {
        ani.makeSound();
    }

}