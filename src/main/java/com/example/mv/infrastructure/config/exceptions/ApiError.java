package com.example.mv.infrastructure.config.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    private final LocalDateTime timestamp;
    private final int code;
    private final String status;
    private final List<String> errors;

    private ApiError(Builder builder) {
        this.timestamp = builder.timestamp;
        this.code = builder.code;
        this.status = builder.status;
        this.errors = builder.errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public static class Builder {
        private LocalDateTime timestamp;
        private int code;
        private String status;
        private List<String> errors;

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder errors(List<String> errors) {
            this.errors = errors;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
