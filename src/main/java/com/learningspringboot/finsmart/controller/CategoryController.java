package com.learningspringboot.finsmart.controller;

import com.learningspringboot.finsmart.dto.category.CategoryRequestDTO;
import com.learningspringboot.finsmart.dto.category.CategoryResponseDTO;
import com.learningspringboot.finsmart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // TODO: adicionar paging
    @GetMapping
    public List<CategoryResponseDTO> list() {
        return service.list();
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        CategoryResponseDTO categoryResponseDTO = service.save(categoryRequestDTO);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
