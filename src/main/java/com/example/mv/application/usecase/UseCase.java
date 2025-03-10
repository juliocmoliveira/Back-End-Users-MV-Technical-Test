package com.example.mv.application.usecase;

import com.example.mv.application.gateway.mapper.UserMapper;
import com.example.mv.application.gateway.repository.UserRepository;

public abstract class UseCase {

    final UserRepository userRepository;
    final UserMapper userMapper;

    public UseCase(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
}
