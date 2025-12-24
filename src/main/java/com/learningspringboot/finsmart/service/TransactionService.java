package com.learningspringboot.finsmart.service;

import com.learningspringboot.finsmart.dto.transaction.TransactionRequestDTO;
import com.learningspringboot.finsmart.dto.transaction.TransactionResponseDTO;
import com.learningspringboot.finsmart.exception.CategoryNotFoundException;
import com.learningspringboot.finsmart.exception.TransactionNotFoundException;
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

    public TransactionResponseDTO save(TransactionRequestDTO transactionRequestDTO) {

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
                .orElseThrow(() -> new CategoryNotFoundException(transactionRequestDTO.getCategoryId()));

        Transaction transaction = new Transaction(
                transactionRequestDTO.getUserId(),
                transactionRequestDTO.getAmount(),
                transactionRequestDTO.getDescription(),
                transactionRequestDTO.getDate(),
                transactionRequestDTO.getType(),
                category
        );

        Transaction result = transactionRepository.save(transaction);

        return new TransactionResponseDTO(
                result.getId(),
                result.getCategory(),
                result.getType(),
                result.getDate(),
                result.getAmount(),
                result.getDescription()
        );
    }

    public List<TransactionResponseDTO> list() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transaction -> {
                    return new TransactionResponseDTO(
                            transaction.getId(),
                            transaction.getCategory(),
                            transaction.getType(),
                            transaction.getDate(),
                            transaction.getAmount(),
                            transaction.getDescription()
                    );
                }).toList();
    }

    public TransactionResponseDTO delete(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("O campo ID deve estar preenchido!");
        }

        Transaction transactionToBeDeleted = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));

        transactionRepository.delete(transactionToBeDeleted);

        return new TransactionResponseDTO(
                transactionToBeDeleted.getId(),
                transactionToBeDeleted.getCategory(),
                transactionToBeDeleted.getType(),
                transactionToBeDeleted.getDate(),
                transactionToBeDeleted.getAmount(),
                transactionToBeDeleted.getDescription()
        );
    }
}
