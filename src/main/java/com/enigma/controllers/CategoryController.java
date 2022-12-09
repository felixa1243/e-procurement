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
import org.springframework.data.domain.PageRequest;
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

    @GetMapping(params = {"page", "size", "sort-by"})
    public ResponseEntity getAll(@RequestParam(name = "page") int page, @RequestParam(name = "size", required = false, defaultValue = "10") int size, @RequestParam(name = "sort-by", defaultValue = "ASC", required = false) String sortBy) {
        Page<Category> pagedResult = service.getAll(PageRequest.of(page, size));
        PagedResponse<Category> result = new PagedResponse<>();
        result.setPage(page);
        result.setSize(size);
        result.setFetchedSize(pagedResult.getNumberOfElements());
        result.setTotalSize(pagedResult.getTotalElements());
        result.setTotalPage(pagedResult.getTotalPages());
        result.setContent(pagedResult.toList());

        return ResponseEntity.status(HttpStatus.OK).body(pagedResult);
    }

    @PostMapping
    public ResponseEntity addOne(@RequestBody CategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(category));
    }
}
