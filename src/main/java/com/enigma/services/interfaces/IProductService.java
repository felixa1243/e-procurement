package com.enigma.services.interfaces;

import com.enigma.entities.Product;
import com.enigma.models.requests.ProductRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IProductService {
    Product create(ProductRequest product) throws Exception;
    Page<Product> getAll(int page, int size, String direction, String sortBy);
    Optional<Product> getById(String id) throws Exception;
    String deleteProduct(String id) throws Exception;
}
