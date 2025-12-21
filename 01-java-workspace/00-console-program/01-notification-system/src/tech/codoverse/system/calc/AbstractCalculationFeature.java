package tech.codoverse.system.calc;

import tech.codoverse.system.AbstractFeature;

public abstract class AbstractCalculationFeature extends AbstractFeature {

    public AbstractCalculationFeature(int id, String featureName) {
        super(id, featureName);
    }

    @Override
    public void doBusiness() {

        IO.println("--- %s feature ---".formatted(getFeatureName()));

        IO.println();

        int a = getNumber("Enter first number: ");

        IO.println();

        int b = getNumber("Enter second number: ");

        IO.println();

        apply(a, b);

        IO.println();

    }

    public abstract void apply(int a, int b);

    private int getNumber(String prompt) {
        return Integer.parseInt(IO.readln(prompt));
    }

}
