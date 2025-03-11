package com.example.mv.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UserRequestPostDTO(

        @NotBlank
        @Schema(description = "Name of user", example = "Júlio Oliveira")
        String name,

        @NotBlank
        @Email
        @Schema(description = "Email of user", example = "juliocesar_morais@outlook.com")
        String email,

        @Schema(description = "Create date of register", example = "2025-03-11 00:03:10")
        LocalDateTime createDate
) { }
