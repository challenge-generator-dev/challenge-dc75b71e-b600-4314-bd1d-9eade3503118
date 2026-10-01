package com.example.productapi.repository;

import com.example.productapi.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para operaciones CRUD sobre la entidad Product.
 * Proporciona métodos para validar nombres duplicados y operaciones básicas de persistencia.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Verifica si existe un producto con el nombre especificado.
     * @param name Nombre del producto a verificar.
     * @return true si existe un producto con ese nombre, false en caso contrario.
     */
    boolean existsByName(String name);

    /**
     * Busca un producto por su nombre.
     * @param name Nombre del producto a buscar.
     * @return Optional que contiene el producto si existe, o vacío si no existe.
     */
    Optional<Product> findByName(String name);
}