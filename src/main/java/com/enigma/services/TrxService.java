package com.enigma.services;

import com.enigma.entities.ProductPrice;
import com.enigma.entities.Vendor;
import com.enigma.entities.transaction.Trx;
import com.enigma.models.requests.TrxRequest;
import com.enigma.repositories.TrxRepo;
import com.enigma.services.interfaces.IPriceService;
import com.enigma.services.interfaces.IProductService;
import com.enigma.services.interfaces.ITrxService;
import com.enigma.services.interfaces.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

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
        Vendor vendor = vendorService.getById(sale.getVendorId()).get();
        System.out.println(sale.getProductId());
        ProductPrice productPrice = priceService.getByProductId(sale.getProductId()).get();
        System.out.println(productPrice);
        Trx trx = new Trx();
        trx.getProduct().add(productPrice);
        trx.setQty(sale.getQty());
        trx.setTrxDate(new Date());
        Trx result = repo.save(trx);
        return result;
    }

    @Override
    public Page<Trx> getAll(int page, int size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return repo.findAll(pageable);
    }
}
