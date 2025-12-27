package xyz.hihasan.ecom.h_commerce.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "H-Commerce API",
        version = "v1",
        description = "Public REST API for H-Commerce platform",
        contact = Contact(
            name = "H-Commerce Backend Team",
            email = "backend@hcommerce.com"
        )
    ),
    servers = [
        Server(
            url = "http://localhost:8080",
            description = "Local environment"
        ),
        Server(
            url = "https://api.hcommerce.com",
            description = "Production environment"
        )
    ]
)
class OpenApiConfig