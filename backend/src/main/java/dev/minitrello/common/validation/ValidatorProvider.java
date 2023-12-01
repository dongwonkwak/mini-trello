package dev.minitrello.common.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorProvider {
    public static final Validator VALIDATOR;

    static {
        var factory = Validation.buildDefaultValidatorFactory();
        VALIDATOR = factory.getValidator();
    }

    public static <T> void validate(T subject) {
        Set<ConstraintViolation<T>> violations = VALIDATOR.validate(subject);
        if (!violations.isEmpty()) {
            var message = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(System.lineSeparator()));
            throw new ConstraintViolationException(message, violations);
        }
    }
}
