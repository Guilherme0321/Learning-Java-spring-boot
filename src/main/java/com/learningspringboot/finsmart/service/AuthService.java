package com.learningspringboot.finsmart.service;

import com.learningspringboot.finsmart.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService service;
    private final AuthenticationManager authenticationManager;

    public AuthService(JwtService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    public String authenticate(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        return service.generateToken(authentication);
    }

    public String authenticate(Authentication authentication) {
        return service.generateToken(authentication);
    }
}
