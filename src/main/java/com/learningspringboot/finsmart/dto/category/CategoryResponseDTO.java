package com.learningspringboot.finsmart.dto.category;

import java.math.BigDecimal;

public class CategoryResponseDTO {

    private Long id;
    private String name;
    private String iconCode;
    private BigDecimal monthlyBudget;

    public CategoryResponseDTO(Long id, String name, String iconCode, BigDecimal monthlyBudget) {
        this.id = id;
        this.name = name;
        this.iconCode = iconCode;
        this.monthlyBudget = monthlyBudget;
    }

    public Long getId() {
        return id;
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
