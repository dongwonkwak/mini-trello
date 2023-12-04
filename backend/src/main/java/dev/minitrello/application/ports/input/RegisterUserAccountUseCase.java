package dev.minitrello.application.ports.input;

import dev.minitrello.application.ports.input.validation.ValidEmail;
import dev.minitrello.application.ports.input.validation.ValidPassword;
import dev.minitrello.application.ports.input.validation.ValidUsername;
import dev.minitrello.domain.UserAccount;
import jakarta.validation.constraints.NotEmpty;


import static dev.minitrello.common.validation.ValidatorProvider.validate;


public interface RegisterUserAccountUseCase {

    UserAccount registerUserAccount(RegisterUserAccountCommand command);


    record RegisterUserAccountCommand(
            @ValidUsername String username,
            @ValidEmail String email,
            @NotEmpty @ValidPassword String password
    )  {
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
}
