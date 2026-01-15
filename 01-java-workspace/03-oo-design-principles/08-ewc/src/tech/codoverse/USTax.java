package tech.codoverse;

public class USTax implements TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return price * 0.07;
    }

}
