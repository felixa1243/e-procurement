package com.enigma.services.interfaces;

import com.enigma.entities.Vendor;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IVendorService {
    Vendor create(Vendor vendor) throws Exception;
    Page<Vendor> getAll(int page, int size, String direction, String sortBy);
    Optional<Vendor> getById(String id) throws Exception;
    String deleteProduct(String id) throws Exception;
}
