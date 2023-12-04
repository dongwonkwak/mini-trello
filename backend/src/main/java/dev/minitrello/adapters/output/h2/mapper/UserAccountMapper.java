package dev.minitrello.adapters.output.h2.mapper;

import dev.minitrello.adapters.output.h2.data.UserAccountData;
import dev.minitrello.domain.UserAccount;
import dev.minitrello.domain.UserAccount.UserAccountId;

public class UserAccountMapper {

    public UserAccount toEntity(UserAccountData userAccountData) {
        return UserAccount.withId(
                new UserAccountId(userAccountData.getUserId()),
                userAccountData.getUsername(),
                userAccountData.getEmail(),
                userAccountData.getPassword(),
                userAccountData.getCreatedAt()
        );
    }

    public UserAccountData fromEntity(UserAccount userAccount) {
        return new UserAccountData(
                userAccount.getId().getValue(),
                userAccount.getUsername(),
                userAccount.getEmail(),
                userAccount.getPassword(),
                userAccount.getCreatedAt()
        );
    }
}
