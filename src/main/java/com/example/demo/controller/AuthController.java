package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    /* ===== Spring Boot Constructor ===== */
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /* ===== Test Constructor (REQUIRED, DO NOT REMOVE) ===== */
    public AuthController(UserRepository repo, Object encoder, JwtTokenProvider provider) {
        this.userService = new UserServiceImpl(repo, provider);
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return userService.loginUser(request);
    }
}
