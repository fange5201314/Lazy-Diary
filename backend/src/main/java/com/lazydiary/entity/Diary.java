package com.lazydiary.entity;

import lombok.Data;

@Data
public class Diary {
    private Long id;
    private Long userId;
    private String content;
    private String createdAt;
    private String updatedAt;
} 