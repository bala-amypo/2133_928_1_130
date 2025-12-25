package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
// REQUIRED BY TESTS (DO NOT REMOVE)
public AuthController(
        com.example.demo.repository.UserRepository userRepository,
        Object passwordEncoder,
        com.example.demo.security.JwtTokenProvider jwtTokenProvider
) {
    this.userService = new com.example.demo.service.impl.UserServiceImpl(userRepository);
}

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }
}
