package com.university.universitymanagement.controller;

import com.university.universitymanagement.dto.auth.request.AuthRequest;
import com.university.universitymanagement.dto.auth.request.RegisterRequest;
import com.university.universitymanagement.service.UserService;
import com.university.universitymanagement.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    // Login endpoint
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        // Get UserDetails and generate token
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    // Register endpoint
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        // Register the user through UserService
        String response = userService.registerUser(registerRequest);

        // If user registration is successful, return the response, otherwise, return an error message
        return response;
    }
}