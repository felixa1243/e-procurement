package com.enigma.services;

import com.enigma.entities.Product;
import com.enigma.entities.ProductPrice;
import com.enigma.repositories.PriceRepo;
import com.enigma.services.interfaces.IPriceService;
import com.enigma.services.interfaces.IProductService;
import com.enigma.shared.NotFoundException;
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
    public Optional<ProductPrice> getByVendorId(String id) throws Exception {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public List<ProductPrice> getAll() {
        return priceRepo.findAll();
    }
}
