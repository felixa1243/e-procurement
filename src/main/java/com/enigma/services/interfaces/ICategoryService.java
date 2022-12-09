package com.enigma.services.interfaces;

import com.enigma.entities.Category;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ICategoryService {
    Category create(Category category);

    Category findByName(String name) throws Exception;

    Optional<Category> findById(String id) throws Exception;

    String delete(String id);

    Page<Category> getAll(int page, int size, String direction, String sortBy);
}
