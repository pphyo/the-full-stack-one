void main() {
	var bool = 5 == 5;
	String result = bool ? "OK" : "Not OK";
	IO.println(result instanceof Object);
}

boolean getTrue() {
	IO.println("getTrue()...");
	return true;
}

boolean getFalse() {
	IO.println("getFalse()...");
	return false;
}

String getValueTwo() {
	IO.println("getValueTwo()...");
	return "Two";
}

String getValueOne() {
	IO.println("getValueOne()...");
	return "One ";
}

void runForAssignment() {

	var x = 10;

	x += 2;

}

void runForIncreDecre() {

	var a = 'a';

	char result = (char)(a++ + ++a);

	IO.println("Result: " + result);
	IO.println("a: " + a);
	
}

void runForPlusSign() {
	var ronaldo = new Player();
	IO.println(2 + ronaldo.toString()); // number, String

	// Result: <result> => Result: 23
	IO.println("Result: " + (2 + 3));
	IO.println("2" + "3");
	IO.println("2" + 3);
	IO.println(2d + "3");
}

class Player {

	int id;
	String name;

}