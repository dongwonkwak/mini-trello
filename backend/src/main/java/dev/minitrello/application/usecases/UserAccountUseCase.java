package dev.minitrello.application.usecases;


import dev.minitrello.domain.entity.UserAccount;

public interface UserAccountUseCase {

    UserAccount registerUserAccount(RegisterUserAccountCommand command);


    record RegisterUserAccountCommand(
        String username,
        String email,
        String password
    ) {}

}
