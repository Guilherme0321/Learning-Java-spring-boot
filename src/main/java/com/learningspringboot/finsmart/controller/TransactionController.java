package com.learningspringboot.finsmart.controller;


import com.learningspringboot.finsmart.dto.transaction.TransactionRequestDTO;
import com.learningspringboot.finsmart.dto.transaction.TransactionResponseDTO;
import com.learningspringboot.finsmart.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    // TODO: ADICIONAR LÓGICA PARA PEGAR O USERID DO AUTHENTICATION
    @PostMapping
    public ResponseEntity<TransactionResponseDTO> save(@RequestBody TransactionRequestDTO transaction, Authentication authentication) {
        System.out.println(authentication.getName());
        TransactionResponseDTO transactionResponseDTO = service.save(transaction);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(transactionResponseDTO);
    }

    // TODO: Adicionar paging
    @GetMapping
    public List<TransactionResponseDTO> list() {
        return service.list();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
