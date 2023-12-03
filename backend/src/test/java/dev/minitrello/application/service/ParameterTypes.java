package dev.minitrello.application.service;

import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType(".*")
    public String name(String username) {
        return username;
    }
}
