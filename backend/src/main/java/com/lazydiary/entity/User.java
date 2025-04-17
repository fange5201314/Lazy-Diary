package com.lazydiary.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String createdAt;
    private String updatedAt;
} 