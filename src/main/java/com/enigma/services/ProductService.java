package com.enigma.services;

import com.enigma.entities.Category;
import com.enigma.entities.Product;
import com.enigma.models.requests.ProductRequest;
import com.enigma.repositories.ProductRepo;
import com.enigma.services.interfaces.IProductService;
import com.enigma.shared.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ProductService implements IProductService {
    @Autowired
    ProductRepo repo;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ModelMapper mapper;

    @Override
    public Product create(ProductRequest product) throws Exception {
        Category category = categoryService.findByName(product.getCategoryName());
        Product mapped = mapper.map(product, Product.class);
        mapped.setCategoryId(category);
        return repo.save(mapped);
    }

    @Override
    public Page<Product> getAll(int page, int size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return repo.findAll(pageable);
    }

    @Override
    public Optional<Product> getById(String id) throws Exception {
        Optional<Product> result = repo.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException("Product with id " + id + " is not found");
        }
        return result;
    }

    @Override
    public String deleteProduct(String id) throws Exception {
        Optional<Product> result = getById(id);
        repo.delete(result.get());
        return "Product with id " + id + " was deleted";
    }

    @Override
    public List<Product> getAll(Set<String> ids) {
        return repo.findAllById(ids);
    }
}
