package dev.minitrello.application.service;

import dev.minitrello.adapters.output.h2.repository.UserAccountRepository;
import dev.minitrello.application.ports.input.RegisterUserAccountUseCase;
import dev.minitrello.application.ports.output.RegisterUserAccountStatePort;
import dev.minitrello.domain.entity.UserAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class RegisterUserAccountStepDefinitions {
    private final RegisterUserAccountStatePort userAccountStatePort =
            Mockito.mock(RegisterUserAccountStatePort.class);
    private final RegisterUserAccountService registerUserAccountService =
            new RegisterUserAccountService(userAccountStatePort);

    @Mock
    UserAccountRepository repository;

    UserAccount userAccount;
    UserAccount savedUserAccount;

    @Given("{name} is not a Mini Trello Member")
    public void notAMiniTrelloMember(String name) {
        this.userAccount = UserTestData.withName(name);
    }

    @When("(s)he registers for a new account")
    public void registersForANewAccount() {
        this.savedUserAccount = this.registerUserAccountService.registerUserAccount(
          new RegisterUserAccountUseCase.RegisterUserAccountCommand(
                  this.userAccount.getUsername(),
                  this.userAccount.getEmail(),
                  this.userAccount.getPassword()
          )
        );
    }

    @Then("(s)he became a Mini Trello member")
    public void becameATrelloMember() {
        //Assertions.assertSame(this.userAccount, this.savedUserAccount);
    }
}
