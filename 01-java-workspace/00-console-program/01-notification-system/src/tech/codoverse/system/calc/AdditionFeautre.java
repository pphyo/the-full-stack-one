package tech.codoverse.system.calc;

public class AdditionFeautre extends AbstractCalculationFeature {

    public AdditionFeautre() {
        super(1, "Addition");
    }

    @Override
    public void apply(int a, int b) {
        IO.println("%d + %d = %d".formatted(a, b, a + b));
    }

}
