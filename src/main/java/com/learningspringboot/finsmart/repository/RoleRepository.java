package com.learningspringboot.finsmart.repository;


import com.learningspringboot.finsmart.model.Role;
import com.learningspringboot.finsmart.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
