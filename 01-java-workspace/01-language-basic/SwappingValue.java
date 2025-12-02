void main() {
	int a = 5, b = 10;

	// Swap using XOR
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;

	IO.println(a);
	IO.println(b);
}