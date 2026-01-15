package tech.codoverse;

public class LspApp {

    void main() {

        Bird ost = new Ostrich();
        ost.eat();

        Bird wp = new WoodPecker();

        if (wp instanceof CanFly f)
            f.fly();

    }

}