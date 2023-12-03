package dev.minitrello.application.domain;

import dev.minitrello.application.ports.input.RegisterUserAccountUseCase.RegisterUserAccountCommand;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("When register new account")
//@SpringBootTest(classes = UserAccount.class)
class UserAccountCommandTest {

    @Test
    @DisplayName("should input valid email address")
    void registerWithInvalidEmail() {
        var ex = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            new RegisterUserAccountCommand(
                "jane",
                "mail",     // invalid email
                "Password1@"
            );
        });

        assertEquals("Email is not valid", ex.getMessage());
    }

    @Test
    @DisplayName("username should be at least 4 characters")
    void registerWithInvalidUsername() {
        var ex = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            new RegisterUserAccountCommand(
                    "TJ",
                    "TJ@minitrello.dev",
                    "Password1@"
            );
        });

        assertEquals("Username is not valid", ex.getMessage());
    }

    @Test
    @DisplayName("password should not contain whitespace")
    void passwordWithWhiteSpace() {
        // password should not contain whitespace
        var ex = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            new RegisterUserAccountCommand(
                    "jane",
                    "jane@minitrello.dev",
                    "Password 1@"
            );
        });

        assertEquals("Password is not strong", ex.getMessage());
    }
}
