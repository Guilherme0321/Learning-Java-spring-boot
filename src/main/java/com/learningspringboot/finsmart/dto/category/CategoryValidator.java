package com.learningspringboot.finsmart.dto.category;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CategoryValidator {

    public void validate(CategoryRequestDTO categoryRequestDTO) {

        if(categoryRequestDTO.getName() == null) {
            throw new IllegalArgumentException("O nome da categoria deve estar preenchido!");
        }

        BigDecimal zero = BigDecimal.valueOf(0.0);
        BigDecimal amount = categoryRequestDTO.getMonthlyBudget();

        if(amount != null && amount.compareTo(zero) < 0) {
            throw new IllegalArgumentException("O valor associado à categoria deve ser maior que 0!");
        }
    }
}
