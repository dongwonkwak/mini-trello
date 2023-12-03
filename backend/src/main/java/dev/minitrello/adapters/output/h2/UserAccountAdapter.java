package dev.minitrello.adapters.output.h2;


import dev.minitrello.adapters.output.h2.mapper.UserAccountMapper;
import dev.minitrello.adapters.output.h2.repository.UserAccountRepository;
import dev.minitrello.application.ports.output.RegisterUserAccountStatePort;
import dev.minitrello.domain.entity.UserAccount;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserAccountAdapter implements RegisterUserAccountStatePort {

    private final UserAccountRepository userAccountRepository;
    private final UserAccountMapper mapper;


    @Override
    public UserAccount persistUserAccount(UserAccount userAccount) {
        //return userAccountRepository
        //return Optional.empty();
        return null;
    }

}
