package dev.minitrello.unittests.domain.useraccount;

import dev.minitrello.application.usecases.UserAccountUseCase.RegisterUserAccountCommand;
import dev.minitrello.domain.entity.UserAccount;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("When register new account")
@SpringBootTest(classes = UserAccount.class)
class UserAccountTest {

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
                    "TJ@minitrello.dev",     // invalid email
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
