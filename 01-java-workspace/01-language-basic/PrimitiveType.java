void main() {

	// declare variables with primtive types
	byte byteVal = 100; // 100 is an int => byte = int
	short shortVal = 130; // 130 is an int => short = int
	int intVal = 200; // compatible => int = int
	long longVal = 1000; // 1000 => long = int

	float floatVal = 300;
	double douleVal = 2000;

	char charVal = '\u1000';
	boolean boolVal = true;

	int kagyi = 'ဂ';

	// String variable
	String strVal = "Hello variables!";

	// 16 bit = 8 bit // smaller type can assign to larger type
	// shortVal = /* (short) */ byteVal; // casting, widening, up, implicit

	byteVal = (byte) shortVal; // narrowing, down, explicit

	System.out.println("Short: " + shortVal);
	System.out.println("Ka gyi: " + kagyi);
	System.out.println("Char: " + charVal);

}