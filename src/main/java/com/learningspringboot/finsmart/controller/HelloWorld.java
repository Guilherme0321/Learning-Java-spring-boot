package com.learningspringboot.finsmart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// STATEFULL -> o estado de cada usuário é armazeno no servidor
// STATELESS -> token de identificação OBS: padrão de rest

// Indica que essa classe é um controller rest
@RestController
@RequestMapping("/hello-world")
public class HelloWorld {

    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }
}
