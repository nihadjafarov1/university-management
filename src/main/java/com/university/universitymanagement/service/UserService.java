package com.university.universitymanagement.service;

import com.university.universitymanagement.dto.auth.request.AuthRequest;
import com.university.universitymanagement.dto.auth.request.RegisterRequest;
import com.university.universitymanagement.dto.auth.response.AuthResponse;

public interface UserService {

    String register(RegisterRequest registerRequest);

    AuthResponse login(AuthRequest authRequest);
}