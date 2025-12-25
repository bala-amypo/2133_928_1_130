package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {

    private final JwtTokenProvider tokenProvider;
    private final CustomUserDetailsService userDetailsService;

    /* ===== SPRING ===== */
    public JwtAuthenticationFilter(
            JwtTokenProvider tokenProvider,
            CustomUserDetailsService uds
    ) {
        this.tokenProvider = tokenProvider;
        this.userDetailsService = uds;
    }

    @Override
    public void doFilter(
            ServletRequest req,
            ServletResponse res,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest r = (HttpServletRequest) req;
        String token = r.getHeader("Authorization");

        if (token != null && tokenProvider.validateToken(token)) {
            tokenProvider.getEmail(token);
        }
        chain.doFilter(req, res);
    }
}
