enum Days {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

record Point(int x, int y) {}

enum Color {
	RED, GREEN, BLUE;
}

void main() {

	var result = runForSwitchPrimitiveTypePM(-10);
	IO.println(result);

}

String runForSwitchPrimitiveTypePM(int value) {

	return switch(value) {
		case 0 -> "Zero";
		case 1 -> "One";
		case 2 -> "Two";
		case int i when i >= 100 -> "Value is greater than 100.";
		case int i -> "Value is greater than 2 and less than 100.";
	};

}

class One {
	public String toString() { return "1"; };
}

class Two extends One {
	public String toString() { return "2"; };
}

class Three extends One {
	public String toString() { return "3"; };
}

String runForSwitchWithObject(Object obj) {

	return switch(obj) {
		case Two two -> two.toString();
        case Three three -> three.toString();
        case One one -> one.toString();
        default -> "Something else";
	};

}

// function add(x, y) {

int runForSwitchExpressionVOne(Days day) {

	int result = switch(day) {
		case Days.MONDAY -> {
			IO.println("Monday");
			yield 1;
		}
		case Days.TUESDAY -> 2;
		case Days.WEDNESDAY -> 3;
		case Days.THURSDAY -> 4;
		case Days.FRIDAY -> 5;
		case Days.SATURDAY -> 6;
		case Days.SUNDAY -> 7;
		default -> 0;
	};

	return result;
}

void runForSwitchStatement(String day) {

	switch(day) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
			IO.println("Weekdays");
			break;
		case "6":
		case "7":
			IO.println("Weekends");
			break;
		default:
			IO.println("Wrong day code!");
	}

	IO.println("Method ended.");

}

void runForIfElseIfElse(int hourOfDay) {

	if(hourOfDay <= 0 || hourOfDay > 24) {
		return;
	}

	if(hourOfDay > 4 && hourOfDay < 12) {
		IO.println("Good Morning!");
	} else if(hourOfDay < 16) {
		IO.println("Good Afternoon!");
	} else if(hourOfDay < 21) {
		IO.println("Good Evening!");
	} else {
		IO.println("Good Night!");
	}

}

void runForIfElse(int hourOfDay) {

	if(hourOfDay < 12) {
		IO.println("Good Morning!");
	} else {
		IO.println("Good Afternoon!");
	}

}

// >, >=, <, <=, ==, !=
// &, &&, |, ||, ^

void runForIf(int num) {

	if(num == 10) {
		IO.println("in if statement.");
		IO.println("Number is equal to 10.");
	}

	IO.println("Method ended.");

}