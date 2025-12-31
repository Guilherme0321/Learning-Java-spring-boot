package com.learningspringboot.finsmart.config;

import com.learningspringboot.finsmart.exception.RoleNotFoundException;
import com.learningspringboot.finsmart.model.RoleName;
import com.learningspringboot.finsmart.model.User;
import com.learningspringboot.finsmart.repository.RoleRepository;
import com.learningspringboot.finsmart.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserAdminConfig implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserAdminConfig(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        var admin = roleRepository.findByName(RoleName.ADMIN)
                .orElseThrow(() -> new RoleNotFoundException(RoleName.ADMIN.name()));

        var userAdmin = userRepository.findByUsername("administrator");

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("Usuário admin já existe!");
                },
                () -> {
                    User adminUser = new User();
                    adminUser.setUsername("administrator");
                    adminUser.setPassword(encoder.encode("administrator"));
                    adminUser.setRoles(Set.of(admin));
                    adminUser.setEnabled(true);
                    adminUser.setCredentialsNonExpired(true);
                    adminUser.setAccountNonLocked(true);
                    adminUser.setAccountNonExpired(true);

                    userRepository.save(adminUser);
                }
        );


    }
}
