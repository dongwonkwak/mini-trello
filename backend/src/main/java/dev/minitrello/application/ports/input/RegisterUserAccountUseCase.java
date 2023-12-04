package dev.minitrello.application.ports.input;

import dev.minitrello.domain.UserAccount;

import java.util.Optional;


public interface RegisterUserAccountUseCase {

    Optional<UserAccount> registerUserAccount(RegisterUserAccountCommand command);

}
