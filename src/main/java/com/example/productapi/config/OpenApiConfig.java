package com.example.productapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Productos")
                        .version("1.0.0")
                        .description("""
                                API REST para la gestión de productos en el sistema.
                                
                                Esta API permite crear, leer, actualizar y eliminar productos,
                                con validación de reglas de negocio como precios positivos
                                y nombres únicos por categoría.
                                
                                ## Características principales
                                - CRUD completo de productos
                                - Validación de precios no negativos
                                - Prevención de nombres duplicados
                                - Documentación interactiva con Swagger
                                - Persistencia en base de datos H2
                                
                                ## Códigos de respuesta
                                - 200: Operación exitosa
                                - 201: Recurso creado correctamente
                                - 400: Error de validación o solicitud inválida
                                - 404: Recurso no encontrado
                                - 409: Conflicto (producto duplicado)
                                - 500: Error interno del servidor
                                """)
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@empresa.com")
                                .url("https://empresa.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Token de autenticación JWT")));
    }
}