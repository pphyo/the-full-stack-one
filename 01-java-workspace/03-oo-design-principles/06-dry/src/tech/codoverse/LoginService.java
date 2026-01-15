package tech.codoverse;

public class LoginService {

    public void login(String email) {
        EmailValidator.validate(email);
        // login logic
    }

}
