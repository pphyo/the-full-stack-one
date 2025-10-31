public class ReferenceType {

	void main() {
		// create object of a class with new and constructor
		// object creation, instance of a class
		// initialization, init
		Person allen = new Person();
		allen.name = "Allen Smith";
		allen.countUp(); // legal but not the right way

		Person ben = new Person();
		ben.eat();

		System.out.println(allen.name);
		System.out.println(ben.name);

		// System.out.println(Person.name); // invalid owner

		Person.countUp(); // the right way

		System.out.println();
		
		System.out.println(Person.count);
		Person.countUp();
		System.out.println(Person.count);

		Person.NestedClass.executeStatic();
	}

}

// members inside class
// variables, methods, blocks, nested class, constructor
// static type, non-static(instance) type
// static members belong to class. Person.countUp();
// instance members belong to object.
// top level class
class Person {

	static class NestedClass {
		static void executeStatic() {
			System.out.println("Executing static nested.");
		}
		void executeInstance() {
			System.out.println("Executing instance nested.");
		}
	}

	class InnerClass {
		static void executeStatic() {
			System.out.println("Executing static inner.");
		}
		void executeInstance() {
			System.out.println("Executing instance inner.");
		}
	}

	static int count; // only declaration
	String name;
	int age = 10; // declaration with assignment
	// age = 20; // error

	// Person() {}

	// static {}

	// {}

	static void countUp() {
		count ++;
		System.out.println("Counting up.");
	}

	static void transitiveCountUp() {
		var person = new Person();
		person.eat();
	}

	// caller, calle
	void eat() {
		countUp();
	}
}


