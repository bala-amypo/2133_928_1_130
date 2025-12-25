package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;

public interface UserService {

    AuthResponse registerUser(RegisterRequest request);

    AuthResponse loginUser(AuthRequest request);
}
