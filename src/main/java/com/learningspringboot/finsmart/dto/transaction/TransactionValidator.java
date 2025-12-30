package com.learningspringboot.finsmart.dto.transaction;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class TransactionValidator {

    public void validate(TransactionRequestDTO transactionRequestDTO) {
        BigDecimal zero = BigDecimal.valueOf(0.0);

        if(transactionRequestDTO == null) {
            throw new IllegalArgumentException("Não permitido passagem de valor nulo para criação do objeto Transaction");
        }

        if(!transactionRequestDTO.getDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data referente a quando a transação foi feita deve ser menor que a atual");
        }

        if(transactionRequestDTO.getAmount().compareTo(zero) < 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que 0");
        }

        if(transactionRequestDTO.getUserId() == null || transactionRequestDTO.getUserId().isEmpty()) {
            throw new IllegalArgumentException("O ID de usuário invalido ou não foi preenchido");
        }
    }
}
