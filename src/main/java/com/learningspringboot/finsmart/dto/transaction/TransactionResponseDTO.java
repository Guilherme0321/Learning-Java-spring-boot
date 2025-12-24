package com.learningspringboot.finsmart.dto.transaction;

import com.learningspringboot.finsmart.dto.category.CategoryResponseDTO;
import com.learningspringboot.finsmart.model.Category;
import com.learningspringboot.finsmart.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponseDTO {

    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime date;
    private TransactionType type;
    private CategoryResponseDTO category;

    public TransactionResponseDTO(Long id, Category category, TransactionType type, LocalDateTime date, BigDecimal amount, String description) {
        this.id = id;
        this.category = new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getIconCode(),
                category.getMonthlyBudget()
        );
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    public CategoryResponseDTO getCategory() {
        return category;
    }
}
