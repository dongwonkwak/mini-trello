package dev.minitrello.application.ports.input.validation;

import dev.minitrello.application.ports.input.validation.PasswordConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Documented
public @interface ValidPassword {
    String message() default "Password is not strong";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
