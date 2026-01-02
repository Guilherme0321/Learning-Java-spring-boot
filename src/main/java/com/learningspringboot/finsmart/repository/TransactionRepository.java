package com.learningspringboot.finsmart.repository;

import com.learningspringboot.finsmart.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser_Id(Long userIdId);

    Page<Transaction> findByUser_Id(Long userIdId, Pageable pageable);

    Optional<Transaction> findByIdAndUser_Id(Long id, Long userId);

}
