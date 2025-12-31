package com.learningspringboot.finsmart.service;

import com.learningspringboot.finsmart.dto.user.UserValidator;
import com.learningspringboot.finsmart.exception.RoleNotFoundException;
import com.learningspringboot.finsmart.exception.UserAlreadyExistsException;
import com.learningspringboot.finsmart.model.Role;
import com.learningspringboot.finsmart.model.RoleName;
import com.learningspringboot.finsmart.model.User;
import com.learningspringboot.finsmart.repository.RoleRepository;
import com.learningspringboot.finsmart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserValidator validator;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder, UserValidator validator, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.validator = validator;
        this.roleRepository = roleRepository;
    }

    public User save(String username, String password) {
        validator.validate(username, password);

        if(userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException(username);
        }

        Role role = roleRepository.findByName(RoleName.USER)
                .orElseThrow(() -> new RoleNotFoundException(RoleName.USER.name()));

        User user = new User();
        user.setUsername(username);
        user.setPassword(
                encoder.encode(password)
        );
        user.setAccountNonExpired(true);
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setRoles(Set.of(new Role[]{role}));

        return userRepository.save(user);
    }
}
