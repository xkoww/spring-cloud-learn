package com.example.feign.service;

import org.springframework.stereotype.Service;

import com.example.feign.feign.BackendUser;
import com.example.feign.models.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final BackendUser backendUser;

    public User getUserName(long userId) {

        return backendUser.getUser(userId);
    }
}
