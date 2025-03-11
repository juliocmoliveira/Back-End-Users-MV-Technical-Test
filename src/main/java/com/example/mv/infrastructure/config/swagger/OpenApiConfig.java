package com.example.mv.infrastructure.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API for return of users",
                version = "1.0.0",
                description = "API documentation"
        ),
        servers = @Server(url = "http://localhost:8081")
)
public class OpenApiConfig {
}
