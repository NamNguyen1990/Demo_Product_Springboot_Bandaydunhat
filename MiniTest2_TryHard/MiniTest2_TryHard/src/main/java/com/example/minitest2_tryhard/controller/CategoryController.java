package com.example.minitest2_tryhard.controller;

import com.example.minitest2_tryhard.model.Category;
import com.example.minitest2_tryhard.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categorys")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAllProduct() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}
