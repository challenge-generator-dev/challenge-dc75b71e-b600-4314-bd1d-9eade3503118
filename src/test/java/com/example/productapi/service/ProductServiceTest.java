package com.example.productapi.service;

import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.dto.ProductRequest;
import com.example.productapi.model.dto.ProductResponse;
import com.example.productapi.model.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product sampleProduct;
    private ProductRequest sampleRequest;

    @BeforeEach
    void setUp() {
        sampleProduct = new Product();
        sampleProduct.setId(1L);
        sampleProduct.setName("Test Product");
        sampleProduct.setPrice(new BigDecimal("29.99"));
        sampleProduct.setStock(10);
        sampleProduct.setCategory("Electronics");

        sampleRequest = new ProductRequest("Test Product", new BigDecimal("29.99"), 10, "Electronics");
    }

    @Test
    void shouldReturnAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(sampleProduct));

        List<ProductResponse> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Product", result.get(0).name());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));

        Optional<ProductResponse> result = productService.getProductById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Product", result.get().name());
    }

    @Test
    void shouldReturnEmptyWhenProductNotFound() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<ProductResponse> result = productService.getProductById(999L);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldCreateProductSuccessfully() {
        when(productRepository.existsByName("Test Product")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(sampleProduct);

        ProductResponse result = productService.createProduct(sampleRequest);

        assertNotNull(result);
        assertEquals("Test Product", result.name());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void shouldThrowExceptionWhenCreatingDuplicateProduct() {
        when(productRepository.existsByName("Test Product")).thenReturn(true);

        assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.createProduct(sampleRequest);
        });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void shouldThrowExceptionWhenCreatingProductWithNegativePrice() {
        ProductRequest invalidRequest = new ProductRequest("Invalid", new BigDecimal("-5.00"), 5, "Books");

        assertThrows(IllegalArgumentException.class, () -> {
            productService.createProduct(invalidRequest);
        });
    }

    @Test
    void shouldUpdateProductStock() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));
        when(productRepository.save(any(Product.class))).thenReturn(sampleProduct);

        ProductResponse result = productService.updateProductStock(1L, 20);

        assertNotNull(result);
        assertEquals(20, result.stock());
    }

    @Test
    void shouldDeleteProduct() {
        when(productRepository.existsById(1L)).thenReturn(true);
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistentProduct() {
        when(productRepository.existsById(999L)).thenReturn(false);

        assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.deleteProduct(999L);
        });
    }
}