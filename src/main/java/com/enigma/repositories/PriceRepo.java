package com.enigma.repositories;

import com.enigma.entities.Product;
import com.enigma.entities.ProductPrice;
import com.enigma.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepo extends JpaRepository<ProductPrice, String> {
    Optional<ProductPrice> findByProduct(Product product);
    Optional<ProductPrice> findByVendor(Vendor vendor);
}
