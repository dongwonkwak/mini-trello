package dev.minitrello.application.ports.input;

import dev.minitrello.application.ports.output.UserManagementOutputPort;
import dev.minitrello.application.usecases.UserAccountUseCase;
import dev.minitrello.domain.entity.UserAccount;


public class UserManagementInputPort implements UserAccountUseCase {
    private final UserManagementOutputPort userManagementOutputPort;

    public UserManagementInputPort(UserManagementOutputPort userManagementOutputPort) {
        this.userManagementOutputPort = userManagementOutputPort;
    }

    @Override
    public UserAccount registerUserAccount(RegisterUserAccountCommand command) {

        return this.userManagementOutputPort.persistUserAccount(
                UserAccount.createUserAccount(
                        command.username(),
                        command.email(),
                        command.password())
        );
    }
}
