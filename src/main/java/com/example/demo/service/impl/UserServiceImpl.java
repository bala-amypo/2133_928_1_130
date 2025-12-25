package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // ✅ REQUIRED constructor for Spring + tests
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ✅ REGISTER USER (test4, test44)
    @Override
    public AuthResponse registerUser(AuthRequest request) {

        Optional<User> existing = userRepository.findByEmail(request.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Set<String> roles = new HashSet<>();
        roles.add("USER"); // ✅ default role required by tests

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();

        User saved = userRepository.save(user);

        String token = jwtTokenProvider.createToken(
                saved.getId(),
                saved.getEmail(),
                saved.getRoles()
        );

        return new AuthResponse(
                token,
                saved.getId(),
                saved.getEmail(),
                saved.getRoles()
        );
    }

    // ✅ LOGIN USER (test5, test43)
    @Override
    public AuthResponse loginUser(AuthRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtTokenProvider.createToken(
                user.getId(),
                user.getEmail(),
                user.getRoles()
        );

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRoles()
        );
    }

    
}
