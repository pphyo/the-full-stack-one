void main() {
	runBreak();
}

// 0 0, 0 2, 0 4
// 1 0, 1 2, 1 4
// 3 
// 4

void runBreak() {

	int i, j;

	for(i = 0; i < 5; i++) {

		if(i == 3) {
			break;
		}

		for(j = 0; j < 10; j = j + 2) {
			
			IO.println("i is %d and j is %d.".formatted(i, j));
		}
		IO.println();

	}

}