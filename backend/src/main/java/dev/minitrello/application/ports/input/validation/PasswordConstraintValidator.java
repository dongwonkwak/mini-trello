package dev.minitrello.application.ports.input.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;


public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        int minSize = 6;
        int maxSize = 16;
        var validator = getPasswordValidator(minSize, maxSize);

        var result = validator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }

        return false;
    }

    private PasswordValidator getPasswordValidator(int minSize, int maxSize) {
        return new PasswordValidator(Arrays.asList(
                new LengthRule(minSize, maxSize),

                // at least one upper-case
                new CharacterRule(EnglishCharacterData.UpperCase, 1),

                // at least one lower-case
                new CharacterRule(EnglishCharacterData.LowerCase, 1),

                // at least one digit
                new CharacterRule(EnglishCharacterData.Digit, 1),

                // at least one symbol
                new CharacterRule(EnglishCharacterData.Special, 1),

                // no whitespace
                new WhitespaceRule()
        ));
    }
}
