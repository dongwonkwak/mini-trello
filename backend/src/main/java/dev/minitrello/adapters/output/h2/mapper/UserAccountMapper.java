package dev.minitrello.adapters.output.h2.mapper;

import dev.minitrello.adapters.output.h2.data.UserAccountData;
import dev.minitrello.domain.entity.UserAccount;
import dev.minitrello.domain.entity.UserAccount.UserAccountId;
import org.springframework.stereotype.Component;

//@Component
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

//    public static UserAccountData fromEntity(UserAccount userAccount) {
//        return new UserAccountData(
//                userAccount.getId().getValue(),
//                userAccount.getUsername(),
//                userAccount.getEmail(),
//                userAccount.getPassword(),
//                userAccount.getCreatedAt()
//        );
//    }
}
