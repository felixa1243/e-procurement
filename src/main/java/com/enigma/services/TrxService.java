package com.enigma.services;

import com.enigma.entities.transaction.Trx;
import com.enigma.models.requests.TrxRequest;
import com.enigma.repositories.TrxRepo;
import com.enigma.services.interfaces.IPriceService;
import com.enigma.services.interfaces.IProductService;
import com.enigma.services.interfaces.ITrxService;
import com.enigma.services.interfaces.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TrxService implements ITrxService {
    @Autowired
    TrxRepo repo;
    @Autowired
    IVendorService vendorService;
    @Autowired
    IProductService productService;
    @Autowired
    IPriceService priceService;

    @Override
    public Trx create(TrxRequest sale) throws Exception {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Page<Trx> getAll(int page, int size, String direction, String sortBy) {
        return null;
    }
}
