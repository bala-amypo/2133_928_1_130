package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserEntity;

public interface UserService {
    UserEntity registerUser(RegisterRequest request);
    UserEntity loginUser(LoginRequest request);
}
