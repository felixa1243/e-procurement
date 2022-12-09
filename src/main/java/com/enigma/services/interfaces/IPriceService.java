package com.enigma.services.interfaces;

import com.enigma.entities.ProductPrice;
import com.enigma.entities.Vendor;
import org.springframework.data.domain.Page;

public interface IPriceService {
    ProductPrice create(ProductPrice price);
    Page<ProductPrice> getAll(int page, int size, String direction, String sortBy);
    ProductPrice update(float oldPrice,float newPrice);
}
