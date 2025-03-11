package com.example.mv.adapters.controller;

import com.example.mv.application.dto.UserRequestPostDTO;
import com.example.mv.application.dto.UserRequestPutDTO;
import com.example.mv.application.dto.UserResponseDTO;
import com.example.mv.application.usecase.CreateUserInteractor;
import com.example.mv.application.usecase.DeleteUserInteractor;
import com.example.mv.application.usecase.ListUsersInteractor;
import com.example.mv.application.usecase.UpdateUserInteractor;
import com.example.mv.domain.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Users", description = "Operations relationship from users")
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

    @Operation(
            summary = "Search for a user using id",
            description = "Returns product details from the given ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success, user found"),
            @ApiResponse(responseCode = "400", description = "Solicitation error"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping("{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(
            @Parameter(description = "ID of the product to be searched for") @PathVariable
            Long userId
    ) {
        return ResponseEntity.ok(listUsersInteractor.getUserById(userId));
    }

    @Operation(
            summary = "Create a new user.",
            description = "Create a new user from the data passed in the body."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success, user created"),
            @ApiResponse(responseCode = "400", description = "Solicitation error"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @PostMapping
    public UserResponseDTO createUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody @RequestBody @Valid
            UserRequestPostDTO userRequestPostDTO
    ) {
        return createUserInteractor.createUser(new User(userRequestPostDTO.name(), userRequestPostDTO.email()));
    }

    @Operation(
            summary = "Updates the corresponding id user.",
            description = "Update the corresponding user id, with the data passed through the body."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success, user updated"),
            @ApiResponse(responseCode = "400", description = "Solicitation error"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @PutMapping("update/{userId}")
    public UserResponseDTO updateUser(
            @PathVariable @Parameter(description = "ID of the product to be update")
            Long userId,
            @RequestBody @Valid
            UserRequestPutDTO userRequestPutDTO) {
        return this.updateUserInteractor.updateUser(userId, new User(userRequestPutDTO.name(), userRequestPutDTO.email()));
    }

    @Operation(
            summary = "Returns a list of saved users.",
            description = "Return a page list of previously saved users."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Solicitation error"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping
    public List<UserResponseDTO> listUsers() {
        return listUsersInteractor.listUsers();
    }

    @Operation(
            summary = "Deletes the user with the corresponding id.",
            description = "It is necessary to pass the user id through the request uri."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Solicitation error"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @DeleteMapping("delete/{userId}")
    public void deleteUsers(@PathVariable Long userId) {
        deleteUserInteractor.deleteUser(userId);
    }
}
