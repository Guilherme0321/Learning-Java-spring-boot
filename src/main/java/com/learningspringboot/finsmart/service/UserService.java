package com.learningspringboot.finsmart.service;

import com.learningspringboot.finsmart.model.User;
import com.learningspringboot.finsmart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// TODO: Adicionar função para verificação do usuário
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User save(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(
                encoder.encode(password)
        );

        return userRepository.save(user);
    }
}
