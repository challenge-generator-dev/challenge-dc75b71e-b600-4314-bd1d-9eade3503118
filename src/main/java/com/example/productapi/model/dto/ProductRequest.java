package com.example.productapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "DTO para la creación y actualización de productos")
public record ProductRequest(

    @Schema(description = "Nombre del producto", example = "Laptop Gamer", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    String name,

    @Schema(description = "Precio del producto", example = "999.99", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0")
    BigDecimal price,

    @Schema(description = "Cantidad disponible en stock", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    Integer stock,

    @Schema(description = "Categoría del producto", example = "Electrónicos", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "La categoría no puede estar vacía")
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    String category
) {
}