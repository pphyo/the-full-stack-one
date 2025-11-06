import java.util.Arrays;

void main() {
	int[] arr = {7, 6, -2, 22, 10, 3, 5};

	IO.println("Length: " + arr.length);
	IO.println(Arrays.toString(arr));

	IO.println(Arrays.toString(Arrays.copyOfRange(arr, 1, 5)));

	Arrays.sort(arr);
	IO.println(Arrays.toString(arr));

	IO.println();

	for(int i = 0; i < arr.length; i = i + 2) {
		IO.println(arr[i]);
	}

	IO.println();

	String[] names = {"Alice", "Bob", "Clara"};

	// basic/traditional for loop
	for(int i = 0; i <= names.length; i++) {
		IO.println(names[i]);
	}


	// enhanced for loop
	// Iterable type
	for(String s : names) {
		System.out.println(s);
	}
}