package tech.codoverse.record;

public record Point(int x, int y) {

    // canonical constructor
    // public Point(int x, int y) {
    // if (x < 0) {
    // throw new IllegalArgumentException();
    // }
    // this.x = x;
    // this.y = y;
    // }

    // Compact constructor
    public Point {
        if (x < 0) {
            x = 2;
        }
    }

    public Point() {
        this(0, 0);
    }

}
