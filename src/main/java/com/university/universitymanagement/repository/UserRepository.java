package com.university.universitymanagement.repository;

import com.university.universitymanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username (used in the UserDetailsServiceImpl)
    Optional<User> findByUsername(String username);

    // Find user by email (if needed)
    Optional<User> findByEmail(String email);
}