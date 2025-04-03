package com.university.universitymanagement.service;

import com.university.universitymanagement.dto.auth.request.AuthRequest;
import com.university.universitymanagement.dto.auth.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String register(RegisterRequest registerRequest) {
        return "User registered successfully";
    }

    @Override
    public String login(AuthRequest authRequest) {
        return "User logged in successfully";
    }
}