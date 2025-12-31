package com.learningspringboot.finsmart.dto.transaction;

import com.learningspringboot.finsmart.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequestDTO {

    // TODO: remover userId
    private Long userId;
    private BigDecimal amount;
    private String description;
    private LocalDateTime date;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private TransactionType type;
    private Long categoryId;

    public TransactionRequestDTO() {};

    public TransactionRequestDTO(
            Long userId,
            BigDecimal amount,
            String description,
            LocalDateTime date,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            TransactionType type,
            Long categoryId
    ) {
        this.userId = userId;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.type = type;
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TransactionType getType() {
        return type;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
