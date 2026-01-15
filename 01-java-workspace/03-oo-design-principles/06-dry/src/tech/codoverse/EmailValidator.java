package tech.codoverse;

public class EmailValidator {

    public static void validate(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

}
