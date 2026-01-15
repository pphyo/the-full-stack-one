package tech.codoverse;

public class EwcApp {

    void main() {

        var order = new Order(1100, new SGTax());
        IO.println("Order Total: " + order.getOrderTotal());

    }

}