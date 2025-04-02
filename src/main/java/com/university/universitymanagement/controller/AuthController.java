package com.university.universitymanagement.controller;

import com.university.universitymanagement.dto.auth.request.AuthRequest;
import com.university.universitymanagement.dto.auth.request.RegisterRequest;
import com.university.universitymanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@RequestMapping("/auth")
public class AuthController {

    UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        return userService.login(authRequest);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }
}