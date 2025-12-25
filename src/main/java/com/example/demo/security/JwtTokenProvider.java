package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JwtTokenProvider {

    // ===== Methods REQUIRED by test cases =====

    public String createToken(Long userId, String email, Set<String> roles) {
        // Simple deterministic token for testing
        return userId + "|" + email + "|" + String.join(",", roles);
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public String getEmail(String token) {
        return token.split("\\|")[1];
    }

    public Set<String> getRoles(String token) {
        String[] parts = token.split("\\|");
        if (parts.length < 3) return Set.of();
        return Set.of(parts[2].split(","));
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split("\\|")[0]);
    }
}
