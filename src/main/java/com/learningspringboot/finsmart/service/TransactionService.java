package com.learningspringboot.finsmart.service;

import com.learningspringboot.finsmart.dto.transaction.TransactionRequestDTO;
import com.learningspringboot.finsmart.dto.transaction.TransactionResponseDTO;
import com.learningspringboot.finsmart.dto.transaction.TransactionValidator;
import com.learningspringboot.finsmart.exception.CategoryNotFoundException;
import com.learningspringboot.finsmart.exception.TransactionNotFoundException;
import com.learningspringboot.finsmart.exception.UserNotFoundException;
import com.learningspringboot.finsmart.model.Category;
import com.learningspringboot.finsmart.model.Transaction;
import com.learningspringboot.finsmart.model.User;
import com.learningspringboot.finsmart.repository.CategoryRepository;
import com.learningspringboot.finsmart.repository.TransactionRepository;
import com.learningspringboot.finsmart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    private final CategoryRepository categoryRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionValidator validator;
    private final UserRepository userRepository;

    @Autowired
    public TransactionService(CategoryRepository categoryRepository, TransactionRepository transactionRepository, TransactionValidator validator, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
        this.validator = validator;
        this.userRepository = userRepository;
    }

    // TODO: pegar o userId do Authentication, ao inves do DTO
    public TransactionResponseDTO save(TransactionRequestDTO transactionRequestDTO) {

        validator.validate(transactionRequestDTO);

        Category category = categoryRepository.findById(transactionRequestDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(transactionRequestDTO.getCategoryId()));

        User user = userRepository.findById(transactionRequestDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException(transactionRequestDTO.getUserId()));

        Transaction transaction = new Transaction(
                user,
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
