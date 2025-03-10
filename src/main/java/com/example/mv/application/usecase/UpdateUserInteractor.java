package com.example.mv.application.usecase;

import com.example.mv.application.dto.UserResponseDTO;
import com.example.mv.application.gateway.mapper.UserMapper;
import com.example.mv.application.gateway.repository.UserRepository;
import com.example.mv.domain.model.User;
import com.example.mv.infrastructure.config.exceptions.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;

public class UpdateUserInteractor extends UseCase {

    public UpdateUserInteractor(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
    }

    public UserResponseDTO updateUser(Long id, User user) {
        try {
            return this.userMapper.toDTO(userRepository.updateUser(id, this.userMapper.toEntityUpdate(user)));
        } catch (EntityNotFoundException e) {
            throw new UserNotFoundException();
        }
    }
}
