package com.example.demo.security;

import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component   // 🔴 THIS IS THE FIX
public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        return "jwt-token-" + userId;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token-");
    }

    public String getEmail(String token) {
        return "user@example.com";
    }

    public Long getUserId(String token) {
        return 1L;
    }

    public Set<String> getRoles(String token) {
        return Set.of("USER");
    }
}
