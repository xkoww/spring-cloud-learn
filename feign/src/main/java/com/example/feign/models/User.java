package com.example.feign.models;

import lombok.Data;


@Data
public class User {
    private Long id;
    private String name;
    private String email;

}