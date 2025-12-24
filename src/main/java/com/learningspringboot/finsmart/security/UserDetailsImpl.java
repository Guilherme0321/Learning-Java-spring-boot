package com.learningspringboot.finsmart.security;

import com.learningspringboot.finsmart.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // TODO: adicionar na classe
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // TODO: adicionar na classe
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // TODO: adicionar na classe
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // TODO: adicionar na classe
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    // TODO: adicionar na classe
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "admin");
    }
}
