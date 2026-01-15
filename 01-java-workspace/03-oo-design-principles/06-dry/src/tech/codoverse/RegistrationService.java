package tech.codoverse;

public class RegistrationService {

    public void register(String email) {
        EmailValidator.validate(email);
        // register logic
    }

}
