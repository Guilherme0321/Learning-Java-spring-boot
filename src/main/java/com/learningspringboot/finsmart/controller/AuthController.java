package com.learningspringboot.finsmart.controller;

import com.learningspringboot.finsmart.model.User;
import com.learningspringboot.finsmart.service.AuthService;
import com.learningspringboot.finsmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.authenticate(username, password);
    }

    @PostMapping("/register")
    public User register(@RequestParam String username, @RequestParam String password) {
        return userService.save(username, password);
    }
}
