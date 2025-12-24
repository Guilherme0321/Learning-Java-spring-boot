package com.learningspringboot.finsmart.dto.category;

import java.math.BigDecimal;

public class CategoryRequestDTO {
    private String name;
    private String iconCode;
    private BigDecimal monthlyBudget;

    public CategoryRequestDTO(String name, String iconCode, BigDecimal monthlyBudget) {
        this.name = name;
        this.iconCode = iconCode;
        this.monthlyBudget = monthlyBudget;
    }

    public String getName() {
        return name;
    }

    public String getIconCode() {
        return iconCode;
    }

    public BigDecimal getMonthlyBudget() {
        return monthlyBudget;
    }
}
