package dev.minitrello.adapters.output.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.minitrello.adapters.output.file.mapper.UserAccountFileMapper;
import dev.minitrello.application.ports.output.UserManagementOutputPort;
import dev.minitrello.domain.entity.UserAccount;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;



public class UserAccountManagementOutputFileAdapter implements UserManagementOutputPort {

    private static UserAccountManagementOutputFileAdapter instance;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserAccountManagementOutputFileAdapter() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    @Override
    public UserAccount persistUserAccount(UserAccount userAccount) {
        var userAccountJson = UserAccountFileMapper.toJson(userAccount);

        try {
            var localDir = Paths.get("").toAbsolutePath().toString();
            var file = new File(localDir + "/users.json");
            file.delete();
            objectMapper.writeValue(file, userAccountJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userAccount;
    }

    @Override
    public Integer countUserAccountByUsername(String username) {
        return null;
    }

    @Override
    public Integer countUserAccountByEmail(String email) {
        return null;
    }

    public static UserAccountManagementOutputFileAdapter getInstance() {
        if (instance == null) {
            instance = new UserAccountManagementOutputFileAdapter();
        }

        return instance;
    }
}
