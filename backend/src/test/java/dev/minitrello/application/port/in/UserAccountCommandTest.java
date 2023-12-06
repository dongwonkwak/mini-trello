package dev.minitrello.application.port.in;

import dev.minitrello.application.ports.input.RegisterUserAccountCommand;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("When register new account")
class UserAccountCommandTest {

    @Test
    @DisplayName("should input valid email address")
    void registerWithInvalidEmail() {
        var ex = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            RegisterUserAccountCommand.builder()
                    .username("janedoe")
                    .email("mail")              // invalid email
                    .password("Password1@")
                    .build();
        });

        assertEquals("Email is not valid", ex.getMessage());
    }

    @Test
    @DisplayName("username should be at least 6 characters")
    void registerWithInvalidUsername() {
        var ex = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            RegisterUserAccountCommand.builder()
                    .username("TJ")
                    .email("TJ@minitrello.dev")
                    .password("Password1@")
                    .build();
        });

        assertEquals("Username is not valid", ex.getMessage());
    }

    @Test
    @DisplayName("password should not contain whitespace")
    void passwordWithWhiteSpace() {
        // password should not contain whitespace
        var ex = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            RegisterUserAccountCommand.builder()
                    .username("jane")
                    .email("jane@minitrello.dev")
                    .password("Password 1@")
                    .build();
        });

        assertEquals("Password is not strong", ex.getMessage());
    }
}
