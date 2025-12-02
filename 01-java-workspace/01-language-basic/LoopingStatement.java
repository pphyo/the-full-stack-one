void main() {
	runNestedFor();
}

void runNestedFor() {

	for(int i = 0; i < 5; i ++) {

		for(int j = 0; j < 5; j ++) {
			IO.print(i + " : ");
			IO.print(j);
			IO.println();
		}
		IO.println();

	}

}

void runBasicFor() {
	int i = 0;
	for(IO.println("init"); i < 5; IO.println("update")) {
		i ++;
		IO.println(i + ": A Ran Han");
	}
}

// void runWhileLoop() {
// 	boolean flag = true;
// 	while(flag) {
		
// 		if(some cond) {
// 			flag = false;
// 		}

// 	}
// }

void runDoWhileLoop(int counter) {

	int i = 0;

	do {
		IO.println(i);
		i++;
	} while(i < counter);

}