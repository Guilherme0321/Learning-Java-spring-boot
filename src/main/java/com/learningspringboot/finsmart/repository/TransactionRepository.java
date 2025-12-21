package com.learningspringboot.finsmart.repository;

import com.learningspringboot.finsmart.model.Category;
import com.learningspringboot.finsmart.model.Transaction;
import com.learningspringboot.finsmart.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCategory(Category category);

    List<Transaction> findByAmountBetween(Double amountAfter, Double amountBefore);

    List<Transaction> findByAmountGreaterThanEqual(Double amountIsGreaterThan);

    List<Transaction> findByAmountLessThanEqual(Double amountIsLessThan);

    List<Transaction> findByType(TransactionType type);

    List<Transaction> findByCreatedAt(LocalDateTime createdAt);

    List<Transaction> findByUpdatedAt(LocalDateTime updatedAt);

}
