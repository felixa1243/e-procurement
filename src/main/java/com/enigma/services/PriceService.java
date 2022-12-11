package com.enigma.services;

import com.enigma.entities.Product;
import com.enigma.entities.ProductPrice;
import com.enigma.repositories.PriceRepo;
import com.enigma.services.interfaces.IPriceService;
import com.enigma.services.interfaces.IProductService;
import com.enigma.shared.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService implements IPriceService {
    @Autowired
    IProductService productService;
    @Autowired
    PriceRepo priceRepo;

    @Override
    public Optional<ProductPrice> getByProductId(String id) throws Exception {
        Product product = productService.getById(id).get();
        Optional<ProductPrice> result = priceRepo.findByProduct(product);
        if (result.isEmpty()) {
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public Optional<ProductPrice> getById(String id) throws Exception {
        Optional<ProductPrice> result = priceRepo.findById(id);
        if (result.isPresent()) {
            return result;
        }

        throw new NotFoundException("Price with id " + id + " not found");
    }

    @Override
    public List<ProductPrice> getAll() {
        return priceRepo.findAll();
    }
}
