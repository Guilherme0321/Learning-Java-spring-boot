package com.learningspringboot.finsmart.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Long id) {
        super("Categoria " + id + "não encontrada!");
    }
}
