package com.university.universitymanagement.service;

import com.university.universitymanagement.dto.auth.request.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
//    User createUser(User user);

    String registerUser(RegisterRequest registerRequest);

    UserDetails loadUserByUsername(String username);
}