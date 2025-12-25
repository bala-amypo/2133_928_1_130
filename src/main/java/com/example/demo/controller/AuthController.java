package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    // ✅ CONSTRUCTOR USED BY SPRING
    public AuthController(UserService userService) {
        this.userService = userService;
        this.jwtTokenProvider = null;
    }

    // ✅ CONSTRUCTOR USED BY TESTNG (MATCHES YOUR UserServiceImpl)
    public AuthController(
            UserRepository userRepository,
            Object passwordEncoderIgnored,   // ignored but required by tests
            JwtTokenProvider jwtTokenProvider
    ) {
        this.userService = new UserServiceImpl(userRepository);
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }
}
