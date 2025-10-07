package com.example.financial_scheduler.transaction.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.financial_scheduler.account.dto.AccountDTO;

import lombok.Data;

@Data
public class TransactionListDTO {

    private Long id;
    private AccountDTO sourceAccount;
    private AccountDTO destinationAccount;
    private Double amount;
    private LocalDate scheduledDate;
    private Double fee;
    private LocalDateTime createdAt;

}
