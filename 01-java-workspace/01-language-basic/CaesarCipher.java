void main() {

	var encryptedText = encrypt("HELLO", (char)18);
	IO.println("Encrypt Text: " + encryptedText);
	IO.println("Decrypt Text: " + encrypt(encryptedText, (char)18));

}

String encrypt(String plainText, char key) {

	StringBuilder encryptedText = new StringBuilder();

	for(char c : plainText.toCharArray()) {
		encryptedText.append((char)(c ^ key));
	}

	return encryptedText.toString();

}

String decrypt(String encryptedText, char key) {
	StringBuilder decryptedText = new StringBuilder();

	for(char c : encryptedText.toCharArray()) {
		decryptedText.append((char)(c ^ key));
	}

	return decryptedText.toString();
}