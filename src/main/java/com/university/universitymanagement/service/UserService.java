package com.university.universitymanagement.service;

import com.university.universitymanagement.dto.auth.request.AuthRequest;
import com.university.universitymanagement.dto.auth.request.RegisterRequest;

public interface UserService {

    String register(RegisterRequest registerRequest);

    String login(AuthRequest authRequest);
}