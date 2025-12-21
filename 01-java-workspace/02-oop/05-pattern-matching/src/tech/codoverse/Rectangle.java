package tech.codoverse;

// final , immutable, constructor, accessor, equals, hashCode, toString
public record Rectangle(double length, double width) implements Shape {

    // Compact construtor
    public Rectangle {
        if (width <= length) {
            throw new IllegalArgumentException("Width must be long from length.");
        }
    }

}

// POJO => Plain Old Java Object
final class Square {
    private final double length;
    private final double width;

    public Square(final double length, final double width) {
        this.length = length;
        this.width = width;
    }

    public final double length() {
        return length;
    }

    public final double width() {
        return width;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Square other = (Square) obj;
        if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
            return false;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Square [length=" + length + ", width=" + width + "]";
    }

}