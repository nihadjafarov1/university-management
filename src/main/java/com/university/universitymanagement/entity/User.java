package com.university.universitymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends CoreEntity implements UserDetails {

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private UserRole role; // Enum-based role system

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        // Make sure roles are prefixed with 'ROLE_' as per Spring Security conventions
        authorities.add(() -> "ROLE_" + role.name());  // Adds role like "ROLE_USER", "ROLE_ADMIN"
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Add logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Add logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Add logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true;  // Add logic if needed
    }
}