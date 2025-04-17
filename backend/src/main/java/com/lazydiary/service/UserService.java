package com.lazydiary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lazydiary.entity.User;

public interface UserService extends IService<User> {
    User findByUsername(String username);
    User findByEmail(String email);
} 