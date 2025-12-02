void main() {

	byte[] data = {1, 2, 3, 4, 5};
	byte checksum = 0;

	for(byte b : data) {
		checksum ^= b;
	}

	IO.println(checksum);

}