package com.learningspringboot.finsmart.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {

    @NotBlank(message = "Username é obrigatório")
    @Size(min = 8, max = 50, message = "Username deve conter entre 8 e 50 caracteres")
    private String username;

    @NotBlank(message = "Senha é obrigatório")
    @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
