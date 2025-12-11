package tech.codoverse.data;

public class Lion extends Mammal {

    static {
        IO.println("Lion's static block");
    }

    {
        IO.println("Lion's instance block");
    }

    public Lion(String color) {
        super(color);
    }

}

/**
 * public Lion() {
 * super();
 * }
 */