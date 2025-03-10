package com.example.mv.infrastructure.config.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found, verify id passed for requisition.");
    }
}
