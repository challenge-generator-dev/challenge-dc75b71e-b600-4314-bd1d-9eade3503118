package com.example.productapi.exception;

public class ProductNotFoundException extends RuntimeException {
    private final Long productId;
    private final String searchCriteria;

    public ProductNotFoundException(Long productId) {
        super(String.format("No se encontró el producto con ID: %d", productId));
        this.productId = productId;
        this.searchCriteria = "id:" + productId;
    }

    public ProductNotFoundException(String productName, boolean byName) {
        super(String.format("No se encontró el producto con nombre: '%s'", productName));
        this.productId = null;
        this.searchCriteria = "name:" + productName;
    }

    public Long getProductId() {
        return productId;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public String getDetailedMessage() {
        if (productId != null) {
            return String.format("Producto no encontrado - ID: %d", productId);
        }
        return String.format("Producto no encontrado - criterio: %s", searchCriteria);
    }

    @Override
    public String toString() {
        return "ProductNotFoundException{" +
                "productId=" + productId +
                ", searchCriteria='" + searchCriteria + '\'' +
                '}';
    }
}