import java.util.Arrays;

void main() {

	int[][] twoDi = new int[3][4];

	twoDi[0][0] = 21;
	twoDi[1][2] = 17;

	// System.out.println(twoDi.length);

	for(int i = 0; i < twoDi.length; i ++) {
		for(int j = 0; j < twoDi[i].length; j ++) {
			IO.println(twoDi[i][j]);
		}
		IO.println();
	}

	IO.println();

	int[][] asym = {{1}, {2, 3}, {4, 5, 6}};
	for(var arr : asym) {
		for(var el : arr) {
			IO.println(el);
		}
		IO.println();
	}

}

// 3 x 4