package com.example.mv.application.gateway.mapper;

import com.example.mv.application.dto.UserResponseDTO;
import com.example.mv.domain.model.User;
import com.example.mv.infrastructure.persistence.entity.UserEntity;

public class UserMapper {

    public UserEntity toEntityInsert(User user) {
        return new UserEntity(user.getName(), user.getEmail(), user.getCreateDate());
    }

    public UserEntity toEntityUpdate(User user) {
        return new UserEntity(user.getName(), user.getEmail());
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getName(), userEntity.getEmail(), userEntity.getCreateDate());
    }

    public UserResponseDTO toDTO(UserEntity userEntity) {
        return new UserResponseDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getCreateDate());
    }
}
