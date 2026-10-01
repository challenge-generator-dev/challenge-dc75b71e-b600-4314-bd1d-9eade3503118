package com.example.productapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(description = "Respuesta de un producto en la API")
public record ProductResponse(
    @Schema(description = "Identificador único del producto", example = "1")
    Long id,
    
    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 15")
    String name,
    
    @Schema(description = "Precio del producto", example = "1299.99")
    BigDecimal price,
    
    @Schema(description = "Cantidad en stock", example = "25")
    Integer stock,
    
    @Schema(description = "Categoría del producto", example = "Electrónica")
    String category
) {}