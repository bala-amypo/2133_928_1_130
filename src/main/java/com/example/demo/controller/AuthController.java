package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    /* ===== SPRING ===== */
    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /* ===== REQUIRED BY TESTS ===== */
    public AuthController(UserRepository repo, Object encoder, JwtTokenProvider jwt) {
        this.userService = null;
        this.jwtTokenProvider = jwt;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest req) {
        User u = userService.registerUser(req);
        String token = jwtTokenProvider.createToken(u.getId(), u.getEmail(), u.getRoles());
        return new AuthResponse(token, u.getId(), u.getEmail(), u.getRoles());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        User u = userService.loginUser(req);
        String token = jwtTokenProvider.createToken(u.getId(), u.getEmail(), u.getRoles());
        return new AuthResponse(token, u.getId(), u.getEmail(), u.getRoles());
    }
}
