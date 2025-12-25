package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.model.User;

public interface UserService {

    User save(User user);

    User findByEmail(String email);

    User getById(Long id);

    User loginUser(AuthRequest request);
}
