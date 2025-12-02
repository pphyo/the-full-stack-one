package tech.codoverse;

import static java.lang.IO.println;

// java.lang.Object
public class Car {

    // static field
    static int id = 10;
    // instance field
    String color;
    int speed;

    // instance block (second execution block while creating object this class)
    {
        println("instance block");
    }

    // static block (the very first execution block while using the class)
    static {
        println("static block");
    }

    // constructor (special method)
    public Car(String color, int speed) {
        if (speed < 0) {
            throw new IllegalArgumentException();
        }

        this.color = color;
        this.speed = speed;

        super();

        println("constructor");
    }

    // instance method
    void brake() {
    }

    // static method
    static void accelerate() {
    }

    // instance inner class
    class InnerClass {

    }

    // static nested class
    static class NestedClass {
    }
}
