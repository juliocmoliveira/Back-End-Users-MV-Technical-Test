package com.example.mv.application.usecase;

import com.example.mv.application.dto.UserResponseDTO;
import com.example.mv.application.gateway.mapper.UserMapper;
import com.example.mv.application.gateway.repository.UserRepository;
import com.example.mv.domain.model.User;

import java.time.LocalDateTime;

public class CreateUserInteractor extends UseCase {

    public CreateUserInteractor(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
    }

    public UserResponseDTO createUser(User user) {
        user.setCreateDate(LocalDateTime.now());
        return this.userMapper.toDTO(userRepository.createUser(this.userMapper.toEntityInsert(user)));
    }
}
