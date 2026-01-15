package tech.codoverse.enumeration;

public enum Operator {

    PLUS('+') {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    MINUS('-') {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    TIMES('\u00d7') {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVIDE('\u00f7') {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    };

    private final char sign;

    private Operator(char sign) {
        this.sign = sign;
    }

    public final char sign() {
        return sign;
    }

    public abstract int apply(int a, int b);

}
