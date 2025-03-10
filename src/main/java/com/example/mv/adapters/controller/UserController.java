package com.example.mv.adapters.controller;

import com.example.mv.application.dto.UserRequestPostDTO;
import com.example.mv.application.dto.UserRequestPutDTO;
import com.example.mv.application.dto.UserResponseDTO;
import com.example.mv.application.usecase.CreateUserInteractor;
import com.example.mv.application.usecase.DeleteUserInteractor;
import com.example.mv.application.usecase.ListUsersInteractor;
import com.example.mv.application.usecase.UpdateUserInteractor;
import com.example.mv.domain.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserInteractor createUserInteractor;
    private final UpdateUserInteractor updateUserInteractor;
    private final ListUsersInteractor listUsersInteractor;
    private final DeleteUserInteractor deleteUserInteractor;

    public UserController(CreateUserInteractor createUserInteractor, UpdateUserInteractor updateUserInteractor, ListUsersInteractor listUsersInteractor, DeleteUserInteractor deleteUserInteractor) {
        this.createUserInteractor = createUserInteractor;
        this.updateUserInteractor = updateUserInteractor;
        this.listUsersInteractor = listUsersInteractor;
        this.deleteUserInteractor = deleteUserInteractor;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(listUsersInteractor.getUserById(id));
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestPostDTO userRequestPostDTO) {
        return createUserInteractor.createUser(new User(userRequestPostDTO.name(), userRequestPostDTO.email()));
    }

    @PutMapping("update/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestPutDTO userRequestPutDTO) {
        return this.updateUserInteractor.updateUser(id, new User(userRequestPutDTO.name(), userRequestPutDTO.email()));
    }

    @GetMapping
    public List<UserResponseDTO> listUsers() {
        return listUsersInteractor.listUsers();
    }

    @DeleteMapping("delete/{id}")
    public void deleteUsers(@PathVariable Long id) {
        deleteUserInteractor.deleteUser(id);
    }
}
