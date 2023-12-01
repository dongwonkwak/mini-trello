package dev.minitrello.application.usecases;


import dev.minitrello.common.validation.ValidPassword;
import dev.minitrello.domain.entity.UserAccount;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


import static dev.minitrello.common.validation.ValidatorProvider.validate;


public interface UserAccountUseCase {

    UserAccount registerUserAccount(@Valid RegisterUserAccountCommand command);


    record RegisterUserAccountCommand(
            @Pattern(message = "Username is not valid", regexp = "[a-zA-Z0-9]{4,12}")
            @NotEmpty String username,
            @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
            @NotEmpty String email,
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
