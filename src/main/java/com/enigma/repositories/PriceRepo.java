package com.enigma.repositories;

import com.enigma.entities.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepo extends JpaRepository<ProductPrice, String> {
}
