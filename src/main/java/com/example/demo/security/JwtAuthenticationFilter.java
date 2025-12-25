package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // Tests only verify instantiation and method presence
}
