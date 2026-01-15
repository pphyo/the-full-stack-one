package tech.codoverse;

public class SGTax implements TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return price * 0.08;
    }

}
