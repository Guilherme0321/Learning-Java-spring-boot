package com.learningspringboot.finsmart.controller;


import com.learningspringboot.finsmart.dto.transaction.TransactionRequestDTO;
import com.learningspringboot.finsmart.dto.transaction.TransactionResponseDTO;
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
    public TransactionResponseDTO save(@RequestBody TransactionRequestDTO transaction) {
        return service.save(transaction);
    }

    @GetMapping
    public List<TransactionResponseDTO> list() {
        return service.list();
    }

    @DeleteMapping("/{id}")
    public TransactionResponseDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
