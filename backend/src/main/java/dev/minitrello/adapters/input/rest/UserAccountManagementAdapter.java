package dev.minitrello.adapters.input.rest;


import dev.minitrello.adapters.input.rest.api.UserApi;
import dev.minitrello.adapters.input.rest.model.SignInReq;
import dev.minitrello.adapters.input.rest.model.SignedInUser;
import dev.minitrello.application.usecases.UserAccountUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.ResponseEntity.*;


@RestController
@RequestMapping("/api")
public class UserAccountManagementAdapter implements UserApi {
    @Override
    public ResponseEntity<SignedInUser> signUp(SignInReq signInReq) {
        var u = new SignedInUser();
        u.setUsername("john");

        var newUser = new UserAccountUseCase.RegisterUserAccountCommand(
                signInReq.getUsername(),
                signInReq.getEmail(),
                signInReq.getPassword()
        );

        return ok(u);
    }
}
