package com.example.mv.application.usecase;

import com.example.mv.application.gateway.mapper.UserMapper;
import com.example.mv.application.gateway.repository.UserRepository;

public class DeleteUserInteractor extends UseCase {

    public DeleteUserInteractor(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteUser(id);
    }
}
