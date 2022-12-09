package com.enigma.controllers;

import com.enigma.entities.Category;
import com.enigma.models.requests.CategoryRequest;
import com.enigma.models.responses.AbsResponse;
import com.enigma.models.responses.CommonResponse;
import com.enigma.models.responses.PagedResponse;
import com.enigma.services.interfaces.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    ICategoryService service;
    @Autowired
    ModelMapper mapper;

    @GetMapping
    public ResponseEntity<AbsResponse> getAll() {
        return ResponseEntity.status(200).body(new CommonResponse<>());
    }

    @GetMapping
    public ResponseEntity<PagedResponse<Category>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction,
            @RequestParam(name = "sortBy", required = false, defaultValue = "productId") String sortBy
    ) {

        Page<Category> products = service.getAll(page, size, direction, sortBy);
        PagedResponse<Category> response = new PagedResponse<>();
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
    public ResponseEntity addOne(@RequestBody CategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(category));
    }
}
