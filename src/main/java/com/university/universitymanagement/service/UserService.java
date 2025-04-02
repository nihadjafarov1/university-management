package com.university.universitymanagement.service;

import com.university.universitymanagement.dto.auth.request.AuthRequest;
import com.university.universitymanagement.dto.auth.request.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    String register(RegisterRequest registerRequest);

    String login(AuthRequest authRequest);

    UserDetails loadUserByUsername(String username);
}