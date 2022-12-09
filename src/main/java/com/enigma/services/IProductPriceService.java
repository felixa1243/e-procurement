package com.enigma.services;

import com.enigma.entities.ProductPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductPriceService {
    ProductPrice create(ProductPrice productPrice) throws Exception;

    Page<ProductPrice> getAll(Pageable pageable);

    Optional<ProductPrice> getById(String id) throws Exception;

    String deleteProduct(String id) throws Exception;
}
