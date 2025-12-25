package com.example.demo.security;

import java.util.Set;

public class JwtTokenProvider {

    public String generateToken(String email, Long userId, Set<String> roles) {
        return "token-" + email;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("token-");
    }

    public String getEmailFromToken(String token) {
        return token.replace("token-", "");
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }

    public Set<String> getRolesFromToken(String token) {
        return Set.of("ROLE_USER");
    }
}
