package com.enigma.services;

import com.enigma.entities.ProductPrice;
import com.enigma.repositories.ProductPriceRepo;
import com.enigma.shared.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductPriceService implements IProductPriceService {
    @Autowired
    ProductPriceRepo repo;

    @Override
    public ProductPrice create(ProductPrice productPrice) throws Exception {
        return repo.save(productPrice);
    }

    @Override
    public Page<ProductPrice> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<ProductPrice> getById(String id) throws Exception {
        Optional<ProductPrice> result = repo.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException("Product Price with id " + id + " was not found..");
        }
        return result;
    }

    @Override
    public String deleteProduct(String id) throws Exception {
        Optional<ProductPrice> result = getById(id);
        repo.delete(result.get());
        return "Product price with id" + id + " was deleted";
    }
}