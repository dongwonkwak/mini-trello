package dev.minitrello.adapters.output.h2;


import dev.minitrello.adapters.output.h2.mapper.UserAccountMapper;
import dev.minitrello.adapters.output.h2.repository.UserAccountRepository;
import dev.minitrello.application.ports.output.RegisterUserAccountStatePort;
import dev.minitrello.common.exception.EmailExistsException;
import dev.minitrello.common.exception.UsernameExistsException;
import dev.minitrello.domain.entity.UserAccount;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserAccountAdapter implements RegisterUserAccountStatePort {

    private final UserAccountRepository userAccountRepository;
    private final UserAccountMapper mapper;


    @Override
    public UserAccount persistUserAccount(UserAccount userAccount) {
        userAccountRepository.findByUsername(userAccount.getUsername())
                .ifPresent(username -> {
                    throw new UsernameExistsException();
                });

        userAccountRepository.findByEmail(userAccount.getEmail())
                .ifPresent(email -> {
                    throw new EmailExistsException();
                });

        userAccountRepository.save(mapper.fromEntity(userAccount));

        return userAccount;
    }

}
