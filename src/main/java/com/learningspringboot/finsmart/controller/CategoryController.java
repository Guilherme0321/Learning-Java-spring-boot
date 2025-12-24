package com.learningspringboot.finsmart.controller;

import com.learningspringboot.finsmart.dto.category.CategoryRequestDTO;
import com.learningspringboot.finsmart.dto.category.CategoryResponseDTO;
import com.learningspringboot.finsmart.model.Category;
import com.learningspringboot.finsmart.repository.CategoryRepository;
import com.learningspringboot.finsmart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoryResponseDTO> list() {
        return service.list();
    }

    @PostMapping
    public CategoryResponseDTO save(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return  service.save(categoryRequestDTO);
    }

    @DeleteMapping("/{id}")
    public CategoryResponseDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
