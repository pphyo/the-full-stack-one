package tech.codoverse;

public class Order {

    private TaxStrategy taxStrategy;
    private double price;

    public Order(double price, TaxStrategy taxStrategy) {
        this.price = price;
        this.taxStrategy = taxStrategy;
    }

    public double getOrderTotal() {
        return price + taxStrategy.calculateTax(price);
    }

}
