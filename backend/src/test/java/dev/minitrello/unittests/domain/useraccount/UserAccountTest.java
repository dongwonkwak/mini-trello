package dev.minitrello.unittests.domain.useraccount;

import dev.minitrello.application.usecases.UserAccountUseCase.RegisterUserAccountCommand;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("When register new account")
class UserAccountTest {

    @Test
    @DisplayName("should input valid email address")
    void registerWithInvalidEmail() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            new RegisterUserAccountCommand(
                "jane",
                "mail",     // invalid email
                "Password1@"
            );
        });
    }

    @Test
    @DisplayName("password should not contain whitespace")
    void passwordWithWhiteSpace() {
        // password should not contain whitespace
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            new RegisterUserAccountCommand(
                    "jane",
                    "jane@minitrello.dev",
                    "Password 1@"
            );
        });
    }





}
