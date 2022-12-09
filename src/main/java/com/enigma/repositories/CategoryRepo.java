package com.enigma.repositories;

import com.enigma.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {
    List<Category> findByCategoryName(String name) throws Exception;
}
