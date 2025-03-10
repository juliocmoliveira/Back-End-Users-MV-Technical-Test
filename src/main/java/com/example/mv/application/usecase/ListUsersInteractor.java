package com.example.mv.application.usecase;

import com.example.mv.application.dto.UserResponseDTO;
import com.example.mv.application.gateway.mapper.UserMapper;
import com.example.mv.application.gateway.repository.UserRepository;
import com.example.mv.infrastructure.config.exceptions.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class ListUsersInteractor extends UseCase {

    public ListUsersInteractor(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
    }

    public UserResponseDTO getUserById(Long id) {
        return this.userRepository.getUserById(id)
                .map(userMapper::toDTO)
                .orElseThrow(UserNotFoundException::new);
    }

    public List<UserResponseDTO> listUsers() {
        return userRepository.listUsers()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }
}
