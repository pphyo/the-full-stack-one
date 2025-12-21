package tech.codoverse;

public abstract class Animal {

    private String type;
    private String color;

    public Animal() {
    }

    public Animal(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public abstract void makeSound();

}
