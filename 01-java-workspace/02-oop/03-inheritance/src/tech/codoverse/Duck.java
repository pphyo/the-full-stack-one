package tech.codoverse;

import tech.codoverse.data.Mammal;

public class Duck extends Mammal {

    public String protVar = "Duck var";

    public void makeSound() {
        IO.println(this.protVar);
        IO.println(super.protVar);
    }

}
