package tech.codoverse;

public class MyanmarTax implements TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return price * 0.05;
    }

}
