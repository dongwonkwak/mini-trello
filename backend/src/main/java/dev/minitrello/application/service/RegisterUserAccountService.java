package dev.minitrello.application.service;

import dev.minitrello.application.ports.output.RegisterUserAccountStatePort;
import dev.minitrello.application.ports.input.RegisterUserAccountUseCase;
import dev.minitrello.application.ports.input.RegisterUserAccountCommand;
import dev.minitrello.domain.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RegisterUserAccountService implements RegisterUserAccountUseCase {
    private final RegisterUserAccountStatePort registerUserAccountStatePort;

    @Override
    public Optional<UserAccount> registerUserAccount(RegisterUserAccountCommand command) {

        return this.registerUserAccountStatePort.persistUserAccount(
                UserAccount.createUserAccount(
                        command.username(),
                        command.email(),
                        command.password())
        );
    }
}
