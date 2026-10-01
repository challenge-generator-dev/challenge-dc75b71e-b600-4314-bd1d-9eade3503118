package com.example.productapi.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    private final String productName;
    private final String category;

    public ProductAlreadyExistsException(String productName) {
        super(String.format("Ya existe un producto con el nombre '%s' en el sistema", productName));
        this.productName = productName;
        this.category = null;
    }

    public ProductAlreadyExistsException(String productName, String category) {
        super(String.format("Ya existe un producto con el nombre '%s' en la categoría '%s'", productName, category));
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getDetailedMessage() {
        if (category != null) {
            return String.format("Producto duplicado: '%s' en categoría '%s'", productName, category);
        }
        return String.format("Producto duplicado: '%s'", productName);
    }

    @Override
    public String toString() {
        return "ProductAlreadyExistsException{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}