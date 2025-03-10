package com.example.mv.infrastructure.config;

import com.example.mv.application.gateway.mapper.UserMapper;
import com.example.mv.adapters.gateway.repository.UserRepositoryImpl;
import com.example.mv.application.gateway.repository.UserRepository;
import com.example.mv.application.usecase.CreateUserInteractor;
import com.example.mv.application.usecase.DeleteUserInteractor;
import com.example.mv.application.usecase.ListUsersInteractor;
import com.example.mv.application.usecase.UpdateUserInteractor;
import com.example.mv.infrastructure.persistence.repository.UserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUserInteractor createUserInteractor(UserRepository userRepository, UserMapper userMapper) {
        return new CreateUserInteractor(userRepository, userMapper);
    }

    @Bean
    UpdateUserInteractor createUpdateUserInteractor(UserRepository userRepository, UserMapper userMapper) {
        return new UpdateUserInteractor(userRepository, userMapper);
    }

    @Bean
    ListUsersInteractor createListUserInteractor(UserRepository userRepository, UserMapper userMapper) {
        return new ListUsersInteractor(userRepository, userMapper);
    }

    @Bean
    DeleteUserInteractor deleteUserInteractor(UserRepository userRepository, UserMapper userMapper) {
        return new DeleteUserInteractor(userRepository, userMapper);
    }

    @Bean
    UserRepositoryImpl createUserRepositoryImpl(UserJpaRepository userJpaRepository) {
        return new UserRepositoryImpl(userJpaRepository);
    }

    @Bean
    UserMapper returnMapper() {
        return new UserMapper();
    }
}
