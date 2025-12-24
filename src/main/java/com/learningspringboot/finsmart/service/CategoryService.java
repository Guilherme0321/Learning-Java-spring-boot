package com.learningspringboot.finsmart.service;

import com.learningspringboot.finsmart.dto.category.CategoryRequestDTO;
import com.learningspringboot.finsmart.dto.category.CategoryResponseDTO;
import com.learningspringboot.finsmart.exception.CategoryNotFoundException;
import com.learningspringboot.finsmart.model.Category;
import com.learningspringboot.finsmart.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryResponseDTO> list() {
        List<Category> categories = repository.findAll();
        return categories.stream()
                .map(category -> {
                   return new CategoryResponseDTO(
                           category.getId(),
                           category.getName(),
                           category.getIconCode(),
                           category.getMonthlyBudget()
                   );
                }).toList();
    }

    public CategoryResponseDTO save(CategoryRequestDTO categoryRequestDTO) {
        if(categoryRequestDTO.getName() == null) {
            throw new IllegalArgumentException("O nome da categoria deve estar preenchido!");
        }

        BigDecimal zero = BigDecimal.valueOf(0.0);
        BigDecimal amount = categoryRequestDTO.getMonthlyBudget();

        if(amount != null && amount.compareTo(zero) < 0) {
            throw new IllegalArgumentException("O valor associado à categoria deve ser maior que 0!");
        }

        Category category = new Category(
                categoryRequestDTO.getName(),
                categoryRequestDTO.getIconCode(),
                categoryRequestDTO.getMonthlyBudget()
        );

        Category result = repository.save(category);

        return new CategoryResponseDTO(
                result.getId(),
                result.getName(),
                result.getIconCode(),
                result.getMonthlyBudget()
        );
    }

    public CategoryResponseDTO delete(Long id) {
        Category categoryToBeDeleted = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        repository.delete(categoryToBeDeleted);

        return new CategoryResponseDTO(
                categoryToBeDeleted.getId(),
                categoryToBeDeleted.getName(),
                categoryToBeDeleted.getIconCode(),
                categoryToBeDeleted.getMonthlyBudget()
        );
    }
}
