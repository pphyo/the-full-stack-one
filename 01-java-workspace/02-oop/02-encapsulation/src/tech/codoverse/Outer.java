package tech.codoverse;

public class Outer {

    void execute() {
        Outer.Nested nested = new Outer.Nested();
        Outer.Inner inner = this.new Inner();

        IO.println(nested);
        IO.println(inner);
    }

    static class Nested {
    }

    class Inner {
    }

}
