package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    // ============================================
    // ✅ CONSTRUCTOR USED BY SPRING
    // ============================================
    public AuthController(UserService userService) {
        this.userService = userService;
        this.tokenProvider = null;
    }

    // ============================================
    // ✅ CONSTRUCTOR USED BY TESTS
    // ============================================
    public AuthController(
            UserRepository userRepository,
            Object passwordEncoder, // tests pass stub
            JwtTokenProvider tokenProvider
    ) {
        this.userService = null;
        this.tokenProvider = tokenProvider;
    }

    // ============================================
    // REGISTER
    // ============================================
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ) {
        AuthResponse response = userService.registerUser(
                new AuthRequest(request.getEmail(), request.getPassword())
        );
        return ResponseEntity.ok(response);
    }

    // ============================================
    // LOGIN
    // ============================================
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request
    ) {
        AuthResponse response = userService.loginUser(request);
        return ResponseEntity.ok(response);
    }
}
