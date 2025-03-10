package com.example.mv.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestPutDTO(@NotBlank String name, @NotBlank @Email String email) {
}
