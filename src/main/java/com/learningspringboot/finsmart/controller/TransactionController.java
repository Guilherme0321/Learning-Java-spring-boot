package com.learningspringboot.finsmart.controller;


import com.learningspringboot.finsmart.dto.TransactionRequestDTO;
import com.learningspringboot.finsmart.model.Transaction;
import com.learningspringboot.finsmart.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction save(@RequestBody TransactionRequestDTO transaction) {
        return service.save(transaction);
    }

    @GetMapping
    public List<Transaction> list() {
        return service.list();
    }
}
