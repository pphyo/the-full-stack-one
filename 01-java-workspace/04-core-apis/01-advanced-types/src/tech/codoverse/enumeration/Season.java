package tech.codoverse.enumeration;

public enum Season {

    WINTER("Low", 5000),
    SPRING("High", 20000),
    SUMMER("Medium", 12000),
    FALL("Low", 5000);

    private final String traffic;
    private final int minimum;

    Season(String traffic, int minimum) {
        this.traffic = traffic;
        this.minimum = minimum;
    }

    public final String traffic() {
        return traffic;
    }

    public final int minimum() {
        return minimum;
    }

}
