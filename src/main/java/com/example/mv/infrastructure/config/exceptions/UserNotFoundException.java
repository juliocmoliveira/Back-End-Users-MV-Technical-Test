package com.example.mv.infrastructure.config.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException() {
        super("User not found, verify id passed for requisition.");
    }
}
