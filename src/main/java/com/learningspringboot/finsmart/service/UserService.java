package com.learningspringboot.finsmart.service;

import com.learningspringboot.finsmart.dto.user.UserValidator;
import com.learningspringboot.finsmart.model.User;
import com.learningspringboot.finsmart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// TODO: adicioanr validator
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserValidator validator;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder, UserValidator validator) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.validator = validator;
    }

    public User save(String username, String password) {
        validator.validate(username, password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(
                encoder.encode(password)
        );

        return userRepository.save(user);
    }
}
