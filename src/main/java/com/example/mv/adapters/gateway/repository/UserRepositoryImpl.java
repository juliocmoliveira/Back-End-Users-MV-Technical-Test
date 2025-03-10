package com.example.mv.adapters.gateway.repository;

import com.example.mv.application.gateway.repository.UserRepository;
import com.example.mv.infrastructure.persistence.entity.UserEntity;
import com.example.mv.infrastructure.persistence.repository.UserJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return this.userJpaRepository.findById(id);
    }

    @Override
    @Transactional
    public UserEntity createUser(UserEntity userEntity) {
        return this.userJpaRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> listUsers() {
        return new ArrayList<>(userJpaRepository.findAll());
    }

    @Override
    @Transactional
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        return userJpaRepository.findById(id)
                .map(existingUser -> {
                    userEntity.setId(existingUser.getId());
                    userEntity.setCreateDate(existingUser.getCreateDate());
                    return userJpaRepository.save(userEntity);
                })
                .orElseThrow(() -> new EntityNotFoundException("User not found by id: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        userJpaRepository.findById(id)
                .ifPresentOrElse(
                        userJpaRepository::delete,
                        () -> { throw new EntityNotFoundException("User not found"); }
                );
    }
}
