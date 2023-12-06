package dev.minitrello.application.ports.input;

import dev.minitrello.application.ports.input.validation.ValidEmail;
import dev.minitrello.application.ports.input.validation.ValidPassword;
import dev.minitrello.application.ports.input.validation.ValidUsername;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import static dev.minitrello.common.validation.ValidatorProvider.validate;

public record RegisterUserAccountCommand(
        @ValidUsername String username,
        @ValidEmail String email,
        @NotEmpty @ValidPassword String password
)  {

    @Builder
    public RegisterUserAccountCommand(
            String username,
            String email,
            String password) {

        this.username = username;
        this.email = email;
        this.password = password;

        validate(this);
    }

}