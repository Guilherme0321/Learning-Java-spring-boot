package com.learningspringboot.finsmart.controller;

import com.learningspringboot.finsmart.dto.auth.LoginRequest;
import com.learningspringboot.finsmart.dto.auth.RegisterRequest;
import com.learningspringboot.finsmart.model.User;
import com.learningspringboot.finsmart.service.AuthService;
import com.learningspringboot.finsmart.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        String token = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest registerRequest) {
        User user = userService.save(registerRequest.getUsername(), registerRequest.getPassword());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }
}
