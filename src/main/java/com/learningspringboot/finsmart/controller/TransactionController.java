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

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> save(@RequestBody TransactionRequestDTO transaction, Authentication authentication) {
        TransactionResponseDTO transactionResponseDTO = service.save(transaction, authentication);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(transactionResponseDTO);
    }

    // TODO: Adicionar paging
    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> list(Authentication authentication) {
        List<TransactionResponseDTO> responseDTOS = service.list(authentication);
        return ResponseEntity.ok(responseDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, Authentication authentication) {
        service.delete(id, authentication);
        return ResponseEntity
                .noContent()
                .build();
    }
}
