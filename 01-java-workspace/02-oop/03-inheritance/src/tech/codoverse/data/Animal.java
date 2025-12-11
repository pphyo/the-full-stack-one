package tech.codoverse.data;

public class Animal {

    static int ANIMAL_COUNT = 100;
    String color;

    static {
        IO.println("Animal's static block");
    }

    {
        IO.println("Animal's instance block");
    }

    public Animal(String color) {
        IO.println("Animal const");
        this.color = color;
    }

    static void move() {
        IO.println("static move()");
    }

    void eat() {
        IO.println("instance eat()");
    }

}

/**
 * public Animal() {
 * super();
 * }
 */