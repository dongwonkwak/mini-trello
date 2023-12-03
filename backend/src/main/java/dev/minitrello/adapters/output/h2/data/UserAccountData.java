package dev.minitrello.adapters.output.h2.data;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_account")
public class UserAccountData implements Serializable {

    @Id
    @Column(name = "user_id",
            columnDefinition = "uuid",
            updatable = false)
    private UUID userId;


    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
