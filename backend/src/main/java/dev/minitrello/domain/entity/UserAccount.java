package dev.minitrello.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class UserAccount {

    @Getter
    private final UserAccountId id;

    @Getter
    @NonNull
    private final String username;

    @Getter
    @NonNull
    private final String email;

    @Getter
    @NonNull
    private final String password;

    @Getter
    private final LocalDateTime createdAt;


    public static UserAccount createUserAccount(
            @NonNull String username,
            @NonNull String email,
            @NonNull String password) {
        return new UserAccount(
                new UserAccountId(UUID.randomUUID()),
                username,
                email,
                password,
                LocalDateTime.now());
    }

    public static UserAccount withId(
            UserAccountId id,
            @NonNull String username,
            @NonNull String email,
            @NonNull String password,
            LocalDateTime createdAt) {
        return new UserAccount(id, username, email, password, createdAt);
    }

    @Value
    public static class UserAccountId {
        private UUID value;
    }
}
