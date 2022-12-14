package com.enigma.controllers;

import com.enigma.entities.ProductPrice;
import com.enigma.models.requests.PriceRequest;
import com.enigma.models.requests.VendorRequest;
import com.enigma.models.responses.CommonResponse;
import com.enigma.models.responses.PagedResponse;
import com.enigma.services.interfaces.IVendorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("vendor")
public class VendorController {
    @Autowired
    IVendorService service;
    @Autowired
    ModelMapper mapper;

    @GetMapping
    public ResponseEntity<PagedResponse<ProductPrice>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction,
            @RequestParam(name = "sortBy", required = false, defaultValue = "priceId") String sortBy
    ) {
        Page<ProductPrice> products = service.getAll(page, size, direction, sortBy);
        System.out.println(products);
        PagedResponse<ProductPrice> response = new PagedResponse<>();
        response.setContent(products.toList());
        response.setPage(page);
        response.setSize(size);
        response.setFetchedSize(products.getNumberOfElements());
        response.setTotalSize(products.getTotalElements());
        response.setTotalPage(products.getTotalPages());
        response.setHasNext(products.hasNext());
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody VendorRequest request) throws Exception {
        return ResponseEntity.status(200).body(service.create(request));
    }

    @PatchMapping("product/{id}")
    public ResponseEntity updatePrice(@PathVariable String id, @RequestBody PriceRequest request) throws Exception {
        ProductPrice result = service.update(id, request.getPrice());
        CommonResponse response = new CommonResponse<>();
        response.setStatus("OK");
        response.setFail(false);
        response.setContent("Update price success");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{id}/products")
    public ResponseEntity getProducts(@PathVariable String id) throws Exception {
        CommonResponse response = new CommonResponse();

        response.setFail(false);
        response.setStatus("OK");
        response.setContent(service.getProduct(id));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
