package dev.minitrello.application.service;

import dev.minitrello.application.ports.output.RegisterUserAccountStatePort;
import dev.minitrello.application.ports.input.RegisterUserAccountUseCase;
import dev.minitrello.domain.entity.UserAccount;



public class RegisterUserAccountService implements RegisterUserAccountUseCase {
    private final RegisterUserAccountStatePort registerUserAccountStatePort;

    public RegisterUserAccountService(RegisterUserAccountStatePort registerUserAccountStatePort) {
        this.registerUserAccountStatePort = registerUserAccountStatePort;
    }

    @Override
    public UserAccount registerUserAccount(RegisterUserAccountCommand command) {

        return this.registerUserAccountStatePort.persistUserAccount(
                UserAccount.createUserAccount(
                        command.username(),
                        command.email(),
                        command.password())
        );
    }
}
