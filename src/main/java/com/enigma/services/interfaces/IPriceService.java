package com.enigma.services.interfaces;

import com.enigma.entities.ProductPrice;

import java.util.List;
import java.util.Optional;

public interface IPriceService {
    Optional<ProductPrice> getByProductId(String id) throws Exception;
    Optional<ProductPrice> getById(String id) throws Exception;
    List<ProductPrice> getAll();
}
