package com.learningspringboot.finsmart.controller;

import com.learningspringboot.finsmart.model.Transaction;
import com.learningspringboot.finsmart.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository repository;

    @Autowired
    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Transaction save(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    @GetMapping
    public List<Transaction> list() {
        return repository.findAll();
    }
}
