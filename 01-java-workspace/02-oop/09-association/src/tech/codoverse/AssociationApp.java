package tech.codoverse;

public class AssociationApp {

    void main() {
        var engine = new PremiumEngine();
        var car = new Car(engine);
        car.move();
    }

    void runForAggregation() {
        var book = new Book();
        var library = new Library(book);
        IO.println(library);
        IO.println(book);

        library = null;
        IO.println(library);
        IO.println(book);
    }

    void runForComposition() {
        var house = new House();
        IO.println(house);
        IO.println(house.getRoom());

        house = null;
        IO.println(house);
    }
}
