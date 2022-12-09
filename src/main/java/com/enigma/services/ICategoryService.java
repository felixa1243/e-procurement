package com.enigma.services;

import com.enigma.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {
    Category create(Category category);
    Category findByName(String name) throws Exception;
    Optional<Category> findById(String id) throws Exception;
    String delete(String id);
    Page<Category> getAll(Pageable pageable);
}
