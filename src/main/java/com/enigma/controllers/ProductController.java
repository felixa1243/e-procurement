package com.enigma.controllers;

import com.enigma.entities.Product;
import com.enigma.models.requests.ProductRequest;
import com.enigma.models.responses.CommonResponse;
import com.enigma.models.responses.PagedResponse;
import com.enigma.services.interfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ModelMapper mapper;

    @PostMapping
    public ResponseEntity<CommonResponse<Product>> create(@RequestBody ProductRequest request) throws Exception {
        CommonResponse<Product> response = new CommonResponse<>();
        response.setStatus("OK");
        response.setContent(productService.create(request));
        response.setFail(false);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<PagedResponse<Product>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction,
            @RequestParam(name = "sortBy", required = false, defaultValue = "productId") String sortBy
    ) {
        Page<Product> products = productService.getAll(page, size, direction, sortBy);
        PagedResponse<Product> response = new PagedResponse<>();
        response.setContent(products.toList());
        response.setPage(page);
        response.setSize(size);
        response.setFetchedSize(products.getNumberOfElements());
        response.setTotalSize(products.getTotalElements());
        response.setTotalPage(products.getTotalPages());
        response.setHasNext(products.hasNext());

        return ResponseEntity.status(200).body(response);
    }
}
