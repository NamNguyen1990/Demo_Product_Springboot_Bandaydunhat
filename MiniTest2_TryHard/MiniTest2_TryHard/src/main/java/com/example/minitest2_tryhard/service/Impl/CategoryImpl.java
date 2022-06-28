package com.example.minitest2_tryhard.service.Impl;

import com.example.minitest2_tryhard.model.Category;
import com.example.minitest2_tryhard.repository.CategoryRepository;
import com.example.minitest2_tryhard.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryImpl implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}

