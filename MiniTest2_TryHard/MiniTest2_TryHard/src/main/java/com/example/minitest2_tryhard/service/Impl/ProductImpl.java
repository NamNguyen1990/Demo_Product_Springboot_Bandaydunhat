package com.example.minitest2_tryhard.service.Impl;

import com.example.minitest2_tryhard.model.Product;
import com.example.minitest2_tryhard.repository.CategoryRepository;
import com.example.minitest2_tryhard.repository.ProductRepository;
import com.example.minitest2_tryhard.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }
}
