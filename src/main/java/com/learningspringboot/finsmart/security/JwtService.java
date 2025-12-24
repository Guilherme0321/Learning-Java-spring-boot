package com.learningspringboot.finsmart.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

// TODO: Adicionar verificação de token
@Component
public class JwtService {
    private final String SECRET_KEY = "I-am-a-tea-bot!";

    // TODO: dicionar mais parametros do usuário
    public String generateToken(String username) {

        int second = 1000;
        int minute = second * 60;
        int hour = minute * 60;

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + hour)
                ).compact();
    }

}
