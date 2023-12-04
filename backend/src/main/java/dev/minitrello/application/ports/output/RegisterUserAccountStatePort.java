package dev.minitrello.application.ports.output;

import dev.minitrello.domain.UserAccount;

import java.util.Optional;


public interface RegisterUserAccountStatePort {
    Optional<UserAccount> persistUserAccount(UserAccount userAccount);
}
