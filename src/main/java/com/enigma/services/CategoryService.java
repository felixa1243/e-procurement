package com.enigma.services;

import com.enigma.entities.Category;
import com.enigma.repositories.CategoryRepo;
import com.enigma.services.interfaces.ICategoryService;
import com.enigma.shared.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepo repo;

    @Override
    public Category create(Category category) {
        return repo.save(category);
    }

    @Override
    public Category findByName(String name) throws Exception {
        List<Category> result = repo.findByCategoryName(name);
        if (result.isEmpty()) {
            throw new NotFoundException("Category not found");
        }
        return result.get(0);
    }

    @Override
    public Optional<Category> findById(String id) throws Exception {
        Optional<Category> result = repo.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException("category with id" + id + "was not found");
        }
        return result;
    }

    @Override
    public String delete(String id) {
        return "category with id " + id + "was not found";
    }

    @Override
    public Page<Category> getAll(int page, int size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return repo.findAll(pageable);
    }
}
