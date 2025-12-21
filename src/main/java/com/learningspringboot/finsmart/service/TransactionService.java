package com.learningspringboot.finsmart.service;

import com.learningspringboot.finsmart.dto.TransactionRequestDTO;
import com.learningspringboot.finsmart.model.Category;
import com.learningspringboot.finsmart.model.Transaction;
import com.learningspringboot.finsmart.repository.CategoryRepository;
import com.learningspringboot.finsmart.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    public final CategoryRepository categoryRepository;
    public final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(CategoryRepository categoryRepository, TransactionRepository transactionRepository) {
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(TransactionRequestDTO transactionRequestDTO) {

        BigDecimal zero = BigDecimal.valueOf(0.0);

        if(transactionRequestDTO == null) {
            throw new IllegalArgumentException("Não permitido passagem de valor nulo para criação do objeto Transaction");
        }

        if(!transactionRequestDTO.getDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data referente a quando a transação foi feita deve ser menor que a atual!");
        }

        if(transactionRequestDTO.getAmount().compareTo(zero) < 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que 0!");
        }

        if(transactionRequestDTO.getUserId() == null) {
            throw new IllegalArgumentException("O ID de usuário invalido!");
        }

        Category category = categoryRepository.findById(transactionRequestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        Transaction transaction = new Transaction(
                transactionRequestDTO.getUserId(),
                transactionRequestDTO.getAmount(),
                transactionRequestDTO.getDescription(),
                transactionRequestDTO.getDate(),
                transactionRequestDTO.getType(),
                category
        );

        return transactionRepository.save(transaction);
    }

    public List<Transaction> list() {
        return transactionRepository.findAll();
    }
}
