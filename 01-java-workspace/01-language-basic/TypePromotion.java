void main() {
	byte byteValue = 127; // legal up, widening, implicit
	short shortValue = (short) 32768; // down, narrowing, explicit
	int intValue = 1000;
	long longValue = 0b1000101011L;

	float floatValue = 1000.0f;
	double doubleValue = 2000.0d;

	short s = 100;
	byte b = (byte) s;

	System.out.println(shortValue);
	System.out.println(floatValue);
	System.out.println(doubleValue);

	System.out.println("Hello, \"Codoverse!\"");
	System.out.println('\u1F7E1' + 0);
}