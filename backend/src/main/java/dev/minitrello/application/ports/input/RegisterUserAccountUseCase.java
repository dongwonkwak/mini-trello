package dev.minitrello.application.ports.input;

import dev.minitrello.domain.UserAccount;


public interface RegisterUserAccountUseCase {

    UserAccount registerUserAccount(RegisterUserAccountCommand command);

}
