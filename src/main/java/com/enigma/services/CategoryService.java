package com.enigma.services;

import com.enigma.entities.Category;
import com.enigma.repositories.CategoryRepo;
import com.enigma.shared.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return repo.findByCategoryName(name).get(0);
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
    public Page<Category> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
