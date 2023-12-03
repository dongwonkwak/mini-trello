package dev.minitrello.adapters.output.h2.repository;

import dev.minitrello.adapters.output.h2.data.UserAccountData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface UserAccountRepository extends JpaRepository<UserAccountData, UUID> {

    Optional<UserAccountData> findByUsername(String username);

    Optional<UserAccountData> findByEmail(String email);
}
