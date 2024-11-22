package com.example.demo.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.context.annotation.Configuration;


@Configuration
@SecuritySchemes({
        @SecurityScheme(
                name = "Bearer",
                type = SecuritySchemeType.APIKEY,
                scheme = "bearer",
                paramName= "Authorization",
                bearerFormat = "JWT",
                in = SecuritySchemeIn.HEADER,
                description = "Enter Bearer token in the format 'Bearer <your-token>'"
        )
})
public class SwaggerConfig {

}
