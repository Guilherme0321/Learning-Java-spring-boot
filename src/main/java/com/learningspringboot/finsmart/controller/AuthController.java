package com.learningspringboot.finsmart.controller;

import com.learningspringboot.finsmart.security.JwtService;
import com.learningspringboot.finsmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final UserService userService;

    @Autowired
    public AuthController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {

        userService.save(username, password);

        return "Usuário criado com sucesso!";
    }

    // TODO: Fazer a validação completa
    @PostMapping("/login")
    public String login(@RequestParam String username) {
        return jwtService.generateToken(username);
    }
}
