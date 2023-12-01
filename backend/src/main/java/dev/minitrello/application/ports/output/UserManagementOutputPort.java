package dev.minitrello.application.ports.output;

import dev.minitrello.domain.entity.UserAccount;



public interface UserManagementOutputPort {
    UserAccount persistUserAccount(UserAccount userAccount);

    Integer countUserAccountByUsername(String username);

    Integer countUserAccountByEmail(String email);
}
