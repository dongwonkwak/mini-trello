package dev.minitrello.application.ports.output;

import dev.minitrello.domain.entity.UserAccount;


public interface UserManagementOutputPort {
    UserAccount persistUserAccount(UserAccount userAccount);

}
