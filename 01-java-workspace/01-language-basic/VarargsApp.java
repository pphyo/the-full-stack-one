void main() {
	execute("");
	execute("", null);
	execute("", 1);
	execute("", 1, 2, 3, 4, 5);
	execute("", new int[]{6, 7, 8, 9});
}

void execute(String label, int... params) {
	IO.println(params);
}

// zero or more
// ... only used in method parameter