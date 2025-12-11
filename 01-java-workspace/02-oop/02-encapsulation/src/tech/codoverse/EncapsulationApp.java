package tech.codoverse;

public class EncapsulationApp {

    void main() {
        Outer outer = new Outer();
        outer.execute();

        Outer.Nested nested = new Outer.Nested();
        Outer.Inner inner = outer.new Inner();

        IO.println(nested);
        IO.println(inner);

        var playerOne = new ImmutablePlayer("Naomi", 90);

        IO.println(playerOne);

        playerOne = new ImmutablePlayer("Naomi", 50);

        IO.println(playerOne);

    }

}