package com.example.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.feign.configuration.CustomErrorDecoder;
import com.example.feign.models.User;

@FeignClient(name = "backend-user", configuration = CustomErrorDecoder.class)
public interface BackendUser {
    
    @GetMapping("/users/{userId}")
    User getUser(@PathVariable("userId") long userId);
    
}
