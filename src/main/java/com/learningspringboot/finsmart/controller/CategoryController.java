package com.learningspringboot.finsmart.controller;

import com.learningspringboot.finsmart.model.Category;
import com.learningspringboot.finsmart.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    @GetMapping
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category save(Category category) {
        return  categoryRepository.save(category);
    }

}
