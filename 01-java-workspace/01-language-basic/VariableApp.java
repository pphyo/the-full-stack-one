public class VariableApp {

	String label; // non-static or instance variable
	static int line; // static variable

	void main(String[] args) {

		// local variable
		boolean isLocal = false; // line 6 to 25

		IO.println(line);
		IO.println(isLocal);

		var app = new VariableApp();
		app.label = "Hello";

		var CONST = calculate(10, 20);

		String label;

		// {
		// 	int innerLocal = 20;
		// 	System.out.println(innerLocal);
		// }

		// System.out.println(innerLocal); // error cannot find symbol

	}

	double calculate(int numOne, int numTwo) {
		int result = numOne + numTwo; // line 22 to 24
		return result;
	}

}

// varOne, varTwo, var1, var2

class Book {}