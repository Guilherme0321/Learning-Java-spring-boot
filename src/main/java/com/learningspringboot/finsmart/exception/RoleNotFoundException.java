package com.learningspringboot.finsmart.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String name) {
        super("Autorização com o nome: " + name + " não existe");
    }
}
