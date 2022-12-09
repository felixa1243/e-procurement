package com.enigma.services.interfaces;

import com.enigma.entities.ProductPrice;
import com.enigma.entities.Vendor;
import com.enigma.models.requests.VendorRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IVendorService {
    Vendor create(VendorRequest vendorRequest) throws Exception;

    Page<ProductPrice> getAll(int page, int size, String direction, String sortBy);

    Optional<Vendor> getById(String id) throws Exception;

    String deleteProduct(String id) throws Exception;
}
