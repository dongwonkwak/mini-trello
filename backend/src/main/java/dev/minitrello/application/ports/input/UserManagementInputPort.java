package dev.minitrello.application.ports.input;

import dev.minitrello.application.ports.output.UserManagementOutputPort;
import dev.minitrello.application.usecases.UserAccountUseCase;
import dev.minitrello.common.exception.EmailExistsException;
import dev.minitrello.common.exception.UsernameExistsException;
import dev.minitrello.domain.entity.UserAccount;

import java.util.Optional;


public class UserManagementInputPort implements UserAccountUseCase {
    private final UserManagementOutputPort userManagementOutputPort;

    public UserManagementInputPort(UserManagementOutputPort userManagementOutputPort) {
        this.userManagementOutputPort = userManagementOutputPort;
    }

    @Override
    public UserAccount registerUserAccount(RegisterUserAccountCommand command) {
        if (userManagementOutputPort.countUserAccountByUsername(command.username()) > 0) {
            throw new UsernameExistsException();
        }

        if (userManagementOutputPort.countUserAccountByEmail(command.email()) > 0) {
            throw new EmailExistsException();
        }

        return this.userManagementOutputPort.persistUserAccount(
                UserAccount.createUserAccount(
                        command.username(),
                        command.email(),
                        command.password())
        );
    }
}
