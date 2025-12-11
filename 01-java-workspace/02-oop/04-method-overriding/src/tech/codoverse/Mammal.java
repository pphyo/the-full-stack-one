package tech.codoverse;

public class Mammal extends Animal {

    public int leg = 4;

    @Override
    public int overWrite(String text, int i) {
        return leg;
    }

}
