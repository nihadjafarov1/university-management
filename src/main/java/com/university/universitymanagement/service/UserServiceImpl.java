package com.university.universitymanagement.service;

import com.university.universitymanagement.dto.auth.request.AuthRequest;
import com.university.universitymanagement.dto.auth.request.RegisterRequest;
import com.university.universitymanagement.dto.auth.response.AuthResponse;
import com.university.universitymanagement.util.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class UserServiceImpl implements UserService {

    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;

    @Override
    public String register(RegisterRequest registerRequest) {
        return "User registered successfully";
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication = authenticate(authRequest.getUsername(), authRequest.getPassword());

        return new AuthResponse(jwtUtil.generateToken(authRequest.getUsername()));
    }

    private Authentication authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}