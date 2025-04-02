package com.university.universitymanagement.service;

import com.university.universitymanagement.dto.auth.request.RegisterRequest;
import com.university.universitymanagement.entity.User;
import com.university.universitymanagement.enums.UserRole;
import com.university.universitymanagement.repository.auth.RoleRepository;
import com.university.universitymanagement.repository.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;


    // Method to check if the username already exists
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    // Method to register a new user
    public String registerUser(RegisterRequest registerRequest) {
        // Step 1: Check if the username already exists
        if (usernameExists(registerRequest.getUsername())) {
            return "Username is already taken!";
        }

        // Step 2: Create a new user object and encode the password
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // Hash the password
        roleRepository.findByName(UserRole.ROLE_STUDENT).ifPresentOrElse(newUser::setRole, () -> {
            throw new RuntimeException("Role not found: " + UserRole.ROLE_STUDENT);
        });

        // Step 3: Save the new user in the database
        userRepository.save(newUser);

        // Step 4: Return a success message
        return "User registered successfully!";
    }

    // Method to load user by username for authentication
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString()))
        );
    }
}