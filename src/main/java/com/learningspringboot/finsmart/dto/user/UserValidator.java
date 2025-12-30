package com.learningspringboot.finsmart.dto.user;

import com.learningspringboot.finsmart.dto.RegexRules;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    private void validateUsername(String username) {
        if(username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username deve estar preenchido");
        }

        if(username.length() < 8 || username.length() > 20) {
            throw new IllegalArgumentException("Username deve ter entre 8 e 50 caracteres");
        }

        if(username.matches(RegexRules.AT_LEAST_SPECIAL_CHARACTERS)) {
            throw new IllegalArgumentException("Username não deve ter caracteres especiais");
        }

        if(!username.matches(RegexRules.AT_LEAST_ONE_LETTER)) {
            throw new IllegalArgumentException("Username deve ter ao menos uma letra");
        }
    }

    private void validatePassword(String password) {
        if(password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password deve estar preenchida");
        }

        if(password.length() < 8) {
            throw new IllegalArgumentException("Password deve pelo menos 8 caracteres");
        }

        if(!password.matches(RegexRules.AT_LEAST_ONE_UPPERCASE)) {
            throw new IllegalArgumentException("Password deve conter letras maiúsculas");
        }

        if(!password.matches(RegexRules.AT_LEAST_ONE_LOWERCASE)) {
            throw new IllegalArgumentException("Password deve conter letras minúsculas");
        }

        if(!password.matches(RegexRules.AT_LEAST_ONE_NUMBER)) {
            throw new IllegalArgumentException("Password deve conter números");
        }

        if(!password.matches(RegexRules.AT_LEAST_SPECIAL_CHARACTERS)) {
            throw new IllegalArgumentException("Password deve conter caracteres especiais");
        }
    }

    public void validate(String username, String password) {
        validateUsername(username);
        validatePassword(password);
    }
}
