package tech.codoverse.record;

public final class ImmutableData {

    private final int data;

    public ImmutableData(final int data) {
        this.data = data;
    }

    public final int data() {
        return data;
    }

    @Override
    public final String toString() {
        return String.valueOf(data);
    }

}
