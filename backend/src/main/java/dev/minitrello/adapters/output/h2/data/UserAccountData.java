package dev.minitrello.adapters.output.h2.data;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eclipse.persistence.annotations.Converter;
import org.eclipse.persistence.annotations.Convert;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_account")
@Converter(name = "uuidConverter", converterClass = UUIDTypeConverter.class)
@MappedSuperclass
public class UserAccountData implements Serializable {

    @Id
    @Column(name = "user_id",
            columnDefinition = "uuid",
            updatable = false)
    @Convert("uuidConverter")
    private UUID userId;


    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "createAt")
    private LocalDateTime createdAt;
}
