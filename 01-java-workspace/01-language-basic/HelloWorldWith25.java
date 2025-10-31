// unnamed class

String name = "David";

void main() {
	IO.println("Hello from JDK 25!");

	greet(name);
}

void greet(String who) {
	IO.println("Hi! %s".formatted(who));
}