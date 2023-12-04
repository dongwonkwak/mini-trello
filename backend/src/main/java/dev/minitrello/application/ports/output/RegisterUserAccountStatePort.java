package dev.minitrello.application.ports.output;

import dev.minitrello.domain.UserAccount;



public interface RegisterUserAccountStatePort {
    UserAccount persistUserAccount(UserAccount userAccount);
}
