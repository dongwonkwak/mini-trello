package dev.minitrello.adapters.input.rest;


import dev.minitrello.adapters.input.rest.api.UserApi;
import dev.minitrello.adapters.input.rest.model.SignUpReq;
import dev.minitrello.adapters.input.rest.model.SignedInUser;
import dev.minitrello.application.ports.input.RegisterUserAccountUseCase;
import dev.minitrello.application.ports.input.RegisterUserAccountCommand;
import dev.minitrello.common.exception.GenericException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import static org.springframework.http.ResponseEntity.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RegisterUserAccountController implements UserApi {
    private final RegisterUserAccountUseCase registerUserAccountUseCase;

    @Override
    public ResponseEntity<SignedInUser> signUp(SignUpReq signUpReq) {
        var newUser = registerUserAccountUseCase.registerUserAccount(
                RegisterUserAccountCommand.builder()
                        .username(signUpReq.getUsername())
                        .email(signUpReq.getEmail())
                        .password(signUpReq.getPassword())
                        .build()
        ).orElseThrow(() -> new GenericException("registerUserAccount fails."));


        var u = new SignedInUser()
                .id(newUser.getId().getValue())
                .username(newUser.getUsername());

        return ok(u);
    }
}
