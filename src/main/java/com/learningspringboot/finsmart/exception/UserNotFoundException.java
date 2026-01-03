package com.learningspringboot.finsmart.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("Usuário com id: " + id + " não encontrado");
    }

    public UserNotFoundException(String username) {
        super("Usuário com username: " + username + " não encontrado");
    }
}



