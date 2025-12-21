package tech.codoverse;

public sealed class Engine permits PremiumEngine, DiselEngine {

    public void start() {
        IO.println("Engine started");
    }

}
