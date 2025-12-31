package com.learningspringboot.finsmart.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username) {
        super("Já existe um usuário com o username " + username);
    }
}
