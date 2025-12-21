package tech.codoverse;

public class PatternMatchingApp {

    void main() {
        testGuarded(new StringBuilder("Java"));
    }

    void testGuarded(CharSequence str) {
        switch (str) {
            case String patTwo when patTwo.length() == 1 -> IO.println("Pattern Two: " + patTwo);
            case String patThree when patThree.isBlank() -> IO.println("String is blank.");
            case String patOne -> {
                if (patOne.length() == 1)
                    IO.println("Pattern One " + patOne);
                else
                    IO.println("Pattern One over 1 " + patOne);
            }
            case StringBuilder patFour -> IO.println("Sb " + (!patFour.isEmpty() ? patFour : ""));
            default -> System.out.println("Not a string");
        }
    }

    void start() {
        var rectangleResult = getPerimeterWithSwitch(new Rectangle(3, 5));
        IO.println("Rectangle Perimeter: " + rectangleResult);

        var circleResult = getPerimeterWithSwitch(new Circle(4.3));
        IO.println("Circle Perimeter: %-10.2f".formatted(circleResult));
    }

    double getPerimeterWithIf(Shape s) {
        if (s instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (s instanceof Circle c) {
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape.");
        }
    }

    double getPerimeterWithSwitch(Shape s) {
        return switch (s) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c -> 2 * c.radius() * Math.PI;
            default -> throw new IllegalArgumentException("Unrecognized shape.");
        };
    }

}