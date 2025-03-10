package com.example.mv.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UserRequestPostDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        LocalDateTime createDate
) { }
