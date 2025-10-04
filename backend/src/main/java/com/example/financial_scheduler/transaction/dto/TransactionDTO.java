package com.example.financial_scheduler.transaction.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDTO {

    private Long sourceAccountId;
    private Long destinationAccountId;
    private Double amount;
    private LocalDate scheduledDate;
    private Double fee;
    private LocalDateTime createdAt;

}
