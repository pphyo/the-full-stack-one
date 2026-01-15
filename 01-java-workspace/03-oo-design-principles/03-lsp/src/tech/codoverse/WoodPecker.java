package tech.codoverse;

public class WoodPecker extends Bird implements CanFly {

    @Override
    public void fly() {
        IO.println("WoodPecker is flying..");
    }

}
