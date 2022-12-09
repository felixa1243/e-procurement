package com.enigma.services;

import com.enigma.entities.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IProductService {
    Product create(Product product) throws Exception;
    Page<Product> getAll(int page, int size, String direction, String sortBy);
    Optional<Product> getById(String id) throws Exception;
    String deleteProduct(String id) throws Exception;
}
