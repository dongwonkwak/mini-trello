package dev.minitrello.adapters.output.h2;


import dev.minitrello.application.ports.output.RegisterUserAccountStatePort;
import dev.minitrello.domain.entity.UserAccount;

import org.springframework.stereotype.Service;


@Service
public class UserAccountAdapter implements RegisterUserAccountStatePort {

    //@Autowired
    //private UserAccountRepository userAccountRepository;


    @Override
    public UserAccount persistUserAccount(UserAccount userAccount) {
        //return userAccountRepository
        //return Optional.empty();
        return null;
    }

}
