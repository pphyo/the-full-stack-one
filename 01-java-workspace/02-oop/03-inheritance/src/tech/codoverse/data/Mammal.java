package tech.codoverse.data;

public class Mammal extends Animal {

    public String pubVar = "Public variable";
    protected String protVar = "Protected variable";
    String defVar = "Private variable";

    static {
        IO.println("Mammal's static block");
    }

    {
        IO.println("Mammal's instance block");
    }

    public Mammal() {
        super("");
    }

    public Mammal(String color) {
        super(color);
    }

}

/**
 * public Mammal() {
 * super();
 * }
 */