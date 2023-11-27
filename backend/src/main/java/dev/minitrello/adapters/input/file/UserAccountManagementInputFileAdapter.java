package dev.minitrello.adapters.input.file;

import dev.minitrello.adapters.input.UserManagementAdapter;
import dev.minitrello.application.usecases.UserAccountUseCase;
import dev.minitrello.domain.entity.UserAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAccountManagementInputFileAdapter extends UserManagementAdapter {

    public UserAccountManagementInputFileAdapter(UserAccountUseCase userAccountUseCase) {
        this.accountUseCase = userAccountUseCase;
    }

    @Override
    public UserAccount processRequest(Object requestParams) {
        var params = stdinParams(requestParams);

        return this.registerUser(params);
    }

    private Map<String, String> stdinParams(Object requestParams) {
        Map<String, String> params = new HashMap<>();

        if (requestParams instanceof Scanner scanner) {
            System.out.println("Please inform username: ");
            var username = scanner.nextLine();
            params.put("username", username);

            System.out.println("Please inform email address:");
            var email = scanner.nextLine();
            params.put("email", email);

            System.out.println("Please inform password: ");
            var password = scanner.nextLine();
            params.put("password", password);

        }

        return params;
    }
}
