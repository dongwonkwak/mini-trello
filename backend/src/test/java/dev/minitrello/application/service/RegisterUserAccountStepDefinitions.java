package dev.minitrello.application.service;

import dev.minitrello.application.ports.input.RegisterUserAccountCommand;
import dev.minitrello.domain.UserAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegisterUserAccountStepDefinitions {

    UserAccount userAccount;

    @Given("{name} is not a Mini Trello Member")
    public void notAMiniTrelloMember(String name) {
        this.userAccount = UserTestData.withName(name);
    }

   @When("he/she tries to register with a username of {}")
   public void triesToRegisterWithAUsernameOf(String username) {
       this.userAccount = UserAccount.withId(
               this.userAccount.getId(),
               username,
               this.userAccount.getEmail(),
               this.userAccount.getPassword(),
               this.userAccount.getCreatedAt()
       );
    }

    @When("he/she tries to register with an email of {}")
    public void triesToRegisterWithAEmailOf(String email) {
        this.userAccount = UserAccount.withId(
                this.userAccount.getId(),
                this.userAccount.getUsername(),
                email,
                this.userAccount.getPassword(),
                this.userAccount.getCreatedAt()
        );
    }

    @Then("^the username should be Accepted.*")
    public void theUsernameShouldBeAccepted() {
        RegisterUserAccountCommand.builder()
                .username(this.userAccount.getUsername())
                .email(this.userAccount.getEmail())
                .password(this.userAccount.getPassword())
                .build();
    }

    @Then("^the username should be Rejected with the message \"(.*)\"")
    public void theUsernameShouldBeRejected(String reason) {
        var exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            RegisterUserAccountCommand.builder()
                    .username(this.userAccount.getUsername())
                    .email(this.userAccount.getEmail())
                    .password(this.userAccount.getPassword())
                    .build();
        });

        assertEquals(reason, exception.getMessage());
    }

    @Then("^the email should be Accepted.*")
    public void theEmailShouldBeAccepted() {
        RegisterUserAccountCommand.builder()
                .username(this.userAccount.getUsername())
                .email(this.userAccount.getEmail())
                .password(this.userAccount.getPassword())
                .build();
    }

    @Then("^the email should be Rejected with the message \"(.*)\"")
    public void theEmailShouldBeRejected(String reason) {
        var exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            RegisterUserAccountCommand.builder()
                    .username(this.userAccount.getUsername())
                    .email(this.userAccount.getEmail())
                    .password(this.userAccount.getPassword())
                    .build();
        });

        assertEquals(reason, exception.getMessage());
    }
}
