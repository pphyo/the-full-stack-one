public class MethodOverloadingApp {

	void main() {
		// overload(0xaL);
		// overload(130.0);
		// overload(200002f);
		overload(1, 2);
	}

	void overload(int... values) {
		IO.println("int varargs: " + values);
	}

	void overload(Integer value) {
		IO.println("Integer: " + value);
	}

	void overload(byte value) {
		IO.println("byte: " + value);
	}

	void overload(short value) {
		IO.println("short: " + value);
	}

	void overload(int value) {
		IO.println("int: " + value);
	}

	// void overload(long value) {
	// 	IO.println("long: " + value);
	// }

	// void overload(float value) {
	// 	IO.println("float: " + value);
	// }

	// void overload(double value) {
	// 	IO.println("double: " + value);
	// }

}

class A {}
class B {}
class C {}