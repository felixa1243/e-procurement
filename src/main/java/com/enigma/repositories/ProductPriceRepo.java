package com.enigma.repositories;

import com.enigma.entities.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepo extends JpaRepository<ProductPrice,String> {
}
