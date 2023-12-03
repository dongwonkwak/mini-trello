package dev.minitrello.application.ports.output;

import dev.minitrello.domain.entity.UserAccount;



public interface RegisterUserAccountStatePort {
    UserAccount persistUserAccount(UserAccount userAccount);
}
