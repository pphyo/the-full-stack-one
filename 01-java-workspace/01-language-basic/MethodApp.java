public class MethodApp {

	// 3.14159265358979323846
	void main() {
		var sumValue = sum(100, 35);
		var result = Math.sin(sumValue);
		IO.println("Sin value of %.1f is %.10f.".formatted(sumValue, result));

		float floatPI = (float) Math.PI;
		double doublePI = Math.PI;

		IO.println("Float PI: %.10f.".formatted(floatPI));
		IO.println("Double PI: %.20f.".formatted(doublePI));

	}

	boolean isEvenTwo(int number) {
		if(number == 0) return true;
		if(number == 1) return false;
		if(number == 2) return true;
		if(number == 4) return true;

		return false;
	}

	boolean isEvenOne(int number) {
		boolean result;
		if(number % 2 == 0) {
			IO.println("Before return in if.");
			result = true;
		} else {
			IO.println("Before return in else.");
			result = false;
		}
		IO.println("Method ends.");
		return result;
	}

	// parameter
	void greet(String message, int counter) {
		for(int i = 0; i < counter; i ++) {
			IO.println(message);
		}
	}

	float sum(long numOne, long numTwo) {
		IO.println("Before return ...");
		return numOne + numTwo;
		// IO.println("After return ...");
	}

}