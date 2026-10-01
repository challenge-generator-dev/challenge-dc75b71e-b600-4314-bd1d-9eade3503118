package com.example.productapi.repository;

import com.example.productapi.model.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private org.springframework.test.context.TestTransaction testTransaction;

    private Product sampleProduct;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();

        sampleProduct = new Product();
        sampleProduct.setName("Test Product");
        sampleProduct.setPrice(new BigDecimal("49.99"));
        sampleProduct.setStock(15);
        sampleProduct.setCategory("Electronics");
        sampleProduct = productRepository.save(sampleProduct);
    }

    @Test
    void shouldSaveProduct() {
        Product newProduct = new Product();
        newProduct.setName("New Product");
        newProduct.setPrice(new BigDecimal("19.99"));
        newProduct.setStock(5);
        newProduct.setCategory("Books");

        Product saved = productRepository.save(newProduct);

        assertNotNull(saved.getId());
        assertEquals("New Product", saved.getName());
        assertEquals(new BigDecimal("19.99"), saved.getPrice());
    }

    @Test
    void shouldFindProductById() {
        Optional<Product> found = productRepository.findById(sampleProduct.getId());

        assertTrue(found.isPresent());
        assertEquals("Test Product", found.get().getName());
    }

    @Test
    void shouldReturnEmptyWhenFindingNonExistentId() {
        Optional<Product> found = productRepository.findById(99999L);

        assertTrue(found.isEmpty());
    }

    @Test
    void shouldFindAllProducts() {
        Product anotherProduct = new Product();
        anotherProduct.setName("Another Product");
        anotherProduct.setPrice(new BigDecimal("9.99"));
        anotherProduct.setStock(20);
        anotherProduct.setCategory("Clothing");
        productRepository.save(anotherProduct);

        var allProducts = productRepository.findAll();

        assertEquals(2, allProducts.size());
    }

    @Test
    void shouldCheckIfProductExistsByName() {
        boolean exists = productRepository.existsByName("Test Product");
        assertTrue(exists);

        boolean notExists = productRepository.existsByName("Non Existent");
        assertFalse(notExists);
    }

    @Test
    void shouldFindProductByName() {
        Optional<Product> found = productRepository.findByName("Test Product");

        assertTrue(found.isPresent());
        assertEquals("Electronics", found.get().getCategory());
    }

    @Test
    void shouldReturnEmptyWhenFindingByNonExistentName() {
        Optional<Product> found = productRepository.findByName("Non Existent Product");

        assertTrue(found.isEmpty());
    }

    @Test
    void shouldDeleteProduct() {
        Long productId = sampleProduct.getId();
        productRepository.deleteById(productId);

        Optional<Product> found = productRepository.findById(productId);
        assertTrue(found.isEmpty());
    }

    @Test
    void shouldUpdateProduct() {
        sampleProduct.setPrice(new BigDecimal("59.99"));
        sampleProduct.setStock(25);
        Product updated = productRepository.save(sampleProduct);

        assertEquals(new BigDecimal("59.99"), updated.getPrice());
        assertEquals(25, updated.getStock());
    }
}