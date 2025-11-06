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

	double calculate(int num1, int num2) {
		int result = num1 + num2; // line 22 to 24
		return result;
	}

}

class Book {}