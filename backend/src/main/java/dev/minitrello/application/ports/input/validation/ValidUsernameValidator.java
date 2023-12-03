package dev.minitrello.application.ports.input.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    private static final int MINLENGTH = 4;
    private static final int MAXLENGTH = 30;
    private static final String regexUsername = String.format("[a-zA-Z0-9._-]{%d,%d}$",
            MINLENGTH, MAXLENGTH);

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username.matches(regexUsername);
    }
}
