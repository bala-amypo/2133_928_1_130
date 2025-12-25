package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final JwtTokenProvider jwt;

    public UserServiceImpl(UserRepository repo, JwtTokenProvider jwt) {
        this.repo = repo;
        this.jwt = jwt;
    }

    @Override
    public AuthResponse registerUser(AuthRequest req) {
        Optional<User> existing = repo.findByEmail(req.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User u = User.builder()
                .email(req.getEmail())
                .password(req.getPassword())
                .build();

        repo.save(u);

        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return new AuthResponse(token, u.getId(), u.getEmail(), u.getRoles());
    }

    @Override
    public AuthResponse loginUser(AuthRequest req) {
        User u = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!u.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return new AuthResponse(token, u.getId(), u.getEmail(), u.getRoles());
    }
}
