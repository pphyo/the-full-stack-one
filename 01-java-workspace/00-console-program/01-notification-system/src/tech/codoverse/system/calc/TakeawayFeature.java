package tech.codoverse.system.calc;

public class TakeawayFeature extends AbstractCalculationFeature {

    public TakeawayFeature() {
        super(2, "Takeaway");
    }

    @Override
    public void apply(int a, int b) {
        IO.println("%d - %d = %d".formatted(a, b, a - b));
    }

}
