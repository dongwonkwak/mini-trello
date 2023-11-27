package dev.minitrello;

import dev.minitrello.adapters.input.UserManagementAdapter;
import dev.minitrello.adapters.input.file.UserAccountManagementInputFileAdapter;
import dev.minitrello.adapters.output.file.UserAccountManagementOutputFileAdapter;
import dev.minitrello.application.ports.input.UserManagementInputPort;
import dev.minitrello.application.ports.output.UserManagementOutputPort;
import dev.minitrello.application.usecases.UserAccountUseCase;

import java.util.Scanner;

public class MiniTrelloApplication {
    private UserManagementAdapter inputAdapter;
    private UserAccountUseCase usecase;
    private UserManagementOutputPort userManagementOutputPort;

    public static void main(String[] args) {
       new MiniTrelloApplication().setAdapter();
    }

    void setAdapter() {
        userManagementOutputPort = UserAccountManagementOutputFileAdapter.getInstance();
        usecase = new UserManagementInputPort(userManagementOutputPort);
        inputAdapter = new UserAccountManagementInputFileAdapter(usecase);
        cli();
    }

    private void cli() {
        Scanner scanner = new Scanner(System.in);
        inputAdapter.processRequest(scanner);
    }
}
