package dev.minitrello.adapters.input;

import dev.minitrello.application.usecases.UserAccountUseCase;
import dev.minitrello.domain.entity.UserAccount;

import java.util.Map;

public abstract class UserManagementAdapter {
    protected UserAccountUseCase accountUseCase;

    public UserAccount registerUser(Map<String, String> params) {
        var newUser = new UserAccountUseCase.RegisterUserAccountCommand(
                params.get("username"),
                params.get("email"),
                params.get("password")
        );

        return accountUseCase.registerUserAccount(newUser);
    }

    public abstract UserAccount processRequest(Object requestParams);
}
