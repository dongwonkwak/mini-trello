package dev.minitrello.common.validation;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

public class Validation {
    private final static Validator validator =
            buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T subject) {
        var violations = validator.validate(subject);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
