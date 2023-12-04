package dev.minitrello.application.service;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import dev.minitrello.domain.UserAccount;

public class UserTestData {
    private static final Config config =
            ConfigFactory.load("testdata/users.conf");

    public static UserAccount withName(String name) {
        var user = config.getConfig(name);
        return UserAccount.createUserAccount(
                user.getString("username"),
                user.getString("email"),
                user.getString("password")
        );
    }
}
