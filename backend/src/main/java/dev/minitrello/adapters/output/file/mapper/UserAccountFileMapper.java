package dev.minitrello.adapters.output.file.mapper;

import dev.minitrello.adapters.output.file.json.UserAccountJson;
import dev.minitrello.domain.entity.UserAccount;

public class UserAccountFileMapper {

    public static UserAccountJson toJson(UserAccount userAccount) {
        var id = userAccount.getId().getValue();
        var username = userAccount.getUsername();
        var email = userAccount.getEmail();
        var password = userAccount.getPassword();
        var createdAt = userAccount.getCreatedAt();

        return new UserAccountJson(id, username, email, password, createdAt);
    }
}
