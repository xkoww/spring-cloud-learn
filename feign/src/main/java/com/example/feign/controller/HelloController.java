package com.example.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.feign.models.User;
import com.example.feign.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
    
    @Autowired
    UserService userService;

    @GetMapping("/hello/{id}")
    public ResponseEntity<User> getOneBook(@PathVariable long id) {
        log.info("Hello user {}", id);
        return ResponseEntity.ok(userService.getUserName(id));
    }

}
