package dev.minitrello.application.ports.input.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUsernameValidator.class)
@Documented
public @interface ValidUsername {

    String message() default "Username is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
