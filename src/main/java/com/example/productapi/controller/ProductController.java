package com.example.productapi.controller;

import com.example.productapi.model.dto.ProductRequest;
import com.example.productapi.model.dto.ProductResponse;
import com.example.productapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Gestión de Productos", description = "API para gestionar productos en el sistema")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Registra un nuevo producto en el sistema con validación de reglas de negocio")
    public ResponseEntity<ProductResponse> createProduct(
            @Parameter(description = "Datos del producto a crear")
            @Valid @RequestBody ProductRequest request) {
        ProductResponse created = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por ID", description = "Retorna los datos de un producto específico")
    public ResponseEntity<ProductResponse> getProduct(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id) {
        ProductResponse product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    @Operation(summary = "Listar todos los productos", description = "Retorna una lista con todos los productos registrados")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto", description = "Actualiza los datos de un producto existente")
    public ResponseEntity<ProductResponse> updateProduct(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nuevos datos del producto")
            @Valid @RequestBody ProductRequest request) {
        ProductResponse updated = productService.updateProduct(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto del sistema")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/stock")
    @Operation(summary = "Actualizar stock de un producto", description = "Modifica la cantidad de stock de un producto existente")
    public ResponseEntity<ProductResponse> updateStock(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nueva cantidad en stock", example = "50")
            @RequestParam Integer quantity) {
        ProductResponse updated = productService.updateProductStock(id, quantity);
        return ResponseEntity.ok(updated);
    }
}