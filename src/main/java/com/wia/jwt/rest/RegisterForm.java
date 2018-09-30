package com.wia.jwt.rest;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterForm {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String repassword;
}
