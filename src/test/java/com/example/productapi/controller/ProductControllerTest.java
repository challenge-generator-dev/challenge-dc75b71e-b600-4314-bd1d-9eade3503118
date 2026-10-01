package com.example.productapi.controller;



import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.entity.Product;
import com.example.productapi.model.dto.ProductRequest;
import com.example.productapi.model.dto.ProductResponse;
import com.example.productapi.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    void shouldReturnAllProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of());

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void shouldReturnProductById() throws Exception {
        ProductResponse response = new ProductResponse(1L, "Test", new BigDecimal("10.00"), 5, "Electronics");
        when(productService.getProductById(1L)).thenReturn(java.util.Optional.of(response));

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test"));
    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest request = new ProductRequest("New Product", new BigDecimal("25.00"), 10, "Electronics");
        ProductResponse response = new ProductResponse(1L, "New Product", new BigDecimal("25.00"), 10, "Electronics");
        when(productService.createProduct(any(ProductRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("New Product"));
    }

    @Test
    void shouldReturnBadRequestWhenCreatingProductWithNegativePrice() throws Exception {
        ProductRequest request = new ProductRequest("Bad Product", new BigDecimal("-10.00"), 5, "Electronics");

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnConflictWhenCreatingDuplicateProduct() throws Exception {
        ProductRequest request = new ProductRequest("Duplicate", new BigDecimal("15.00"), 3, "Books");
        when(productService.createProduct(any(ProductRequest.class)))
                .thenThrow(new com.example.productapi.exception.ProductAlreadyExistsException("Duplicate"));

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict());
    }
}