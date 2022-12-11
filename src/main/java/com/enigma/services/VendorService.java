package com.enigma.services;

import com.enigma.entities.Product;
import com.enigma.entities.ProductPrice;
import com.enigma.entities.Vendor;
import com.enigma.models.requests.VendorRequest;
import com.enigma.repositories.PriceRepo;
import com.enigma.repositories.VendorRepo;
import com.enigma.services.interfaces.IPriceService;
import com.enigma.services.interfaces.IProductService;
import com.enigma.services.interfaces.IVendorService;
import com.enigma.shared.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class VendorService implements IVendorService {
    @Autowired
    VendorRepo repo;
    @Autowired
    IProductService productService;
    @Autowired
    PriceRepo priceRepo;
    @Autowired
    IPriceService priceService;
    @Autowired
    ModelMapper mapper;

    @Override
    public Vendor create(VendorRequest vendorRequest) throws Exception {

        Product product = productService.getById(vendorRequest.getProducts()).get();

        Vendor vendor = repo.save(mapper.map(vendorRequest, Vendor.class));
        ProductPrice price = new ProductPrice();

        price.setVendor(vendor);
        price.setProduct(product);
        price.setPrice(vendorRequest.getPrice());
        price.setActive(true);

        vendor.getProducts().add(price);
        priceRepo.save(price);
        System.out.println(priceRepo.findAll());
        return vendor;
    }

    @Override
    public Page<ProductPrice> getAll(int page, int size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return priceRepo.findAll(pageable);
    }

    @Override
    public List<ProductPrice> getAll() {
        return priceRepo.findAll();
    }

    @Override
    public Optional<Vendor> getById(String id) throws Exception {
        Optional<Vendor> result = repo.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public String deleteProduct(String id) throws Exception {
        Optional<Vendor> result = getById(id);
        repo.delete(result.get());
        return "Vendor with id " + id + " was deleted";
    }

    @Override
    public ProductPrice update(String id, float newPrice) throws Exception {
        ProductPrice result = priceService.getByProductId(id).get();
        result.setActive(false);
        priceRepo.save(result);
        result.setPrice(newPrice);
        result.setActive(true);
        priceRepo.save(result);
        return result;
    }

    @Override
    public Set<ProductPrice> getProduct(String id) throws Exception {
        Vendor vendor = getById(id).get();
        return vendor.getProducts();
    }

    @Override
    public ProductPrice getPriceByVendorId(String id) throws Exception {
        Vendor vendor = getById(id).get();
        Optional<ProductPrice> result = priceRepo.findByVendor(vendor);
        if (result.isEmpty()) {
            throw new NotFoundException();
        }
        return result.get();
    }
}
