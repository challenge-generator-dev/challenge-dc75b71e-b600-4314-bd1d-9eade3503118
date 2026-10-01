package com.example.productapi.service;

import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.dto.ProductRequest;
import com.example.productapi.model.dto.ProductResponse;
import com.example.productapi.model.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        validatePriceNotNegative(request.price());
        validateNameNotDuplicated(request.name());

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCategory(request.category());

        Product saved = productRepository.save(product);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));
        return toResponse(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

        validatePriceNotNegative(request.price());
        if (!existing.getName().equals(request.name())) {
            validateNameNotDuplicated(request.name());
        }

        existing.setName(request.name());
        existing.setPrice(request.price());
        existing.setStock(request.stock());
        existing.setCategory(request.category());

        Product updated = productRepository.save(existing);
        return toResponse(updated);
    }

    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductResponse updateProductStock(Long id, Integer quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

        if (quantity < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        product.setStock(quantity);
        Product updated = productRepository.save(product);
        return toResponse(updated);
    }

    private void validatePriceNotNegative(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("El precio es obligatorio");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    private void validateNameNotDuplicated(String name) {
        if (productRepository.existsByName(name)) {
            throw new ProductAlreadyExistsException("Ya existe un producto con el nombre: " + name);
        }
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCategory()
        );
    }
}