package com.example.mv.application.gateway.repository;

import com.example.mv.infrastructure.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> getUserById(Long id);
    UserEntity createUser(UserEntity userEntity);
    List<UserEntity> listUsers();
    UserEntity updateUser(Long id, UserEntity userEntity);
    void deleteUser(Long id);

}
