package com.example.mv.application.dto;

import java.time.LocalDateTime;

public record UserResponseDTO(Long id, String name, String email, LocalDateTime createDate) {
}
