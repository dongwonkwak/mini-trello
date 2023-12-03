package dev.minitrello.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class UserAccount {
    private final UserAccountId id;

    @NonNull
    private final String username;


    @NonNull
    private final String email;


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
