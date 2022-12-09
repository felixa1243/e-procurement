package com.enigma.services;

import com.enigma.entities.Vendor;
import com.enigma.repositories.VendorRepo;
import com.enigma.services.interfaces.IVendorService;
import com.enigma.shared.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class VendorService implements IVendorService {
    @Autowired
    VendorRepo repo;

    @Override
    public Vendor create(Vendor vendor) throws Exception {
        return repo.save(vendor);
    }

    @Override
    public Page<Vendor> getAll(int page, int size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return repo.findAll(pageable);
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
}
