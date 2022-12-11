package com.enigma.services.interfaces;

import com.enigma.entities.ProductPrice;
import com.enigma.entities.Vendor;
import com.enigma.models.requests.VendorRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IVendorService {
    Vendor create(VendorRequest vendorRequest) throws Exception;

    Page<ProductPrice> getAll(int page, int size, String direction, String sortBy);
    List<ProductPrice> getAll();

    Optional<Vendor> getById(String id) throws Exception;

    String deleteProduct(String id) throws Exception;

    ProductPrice update(String id, float newPrice) throws Exception;

    Set<ProductPrice> getProduct(String id) throws Exception;

    ProductPrice getPriceByVendorId(String id) throws Exception;
}
