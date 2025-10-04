package com.example.financial_scheduler.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financial_scheduler.common.exceptions.RuleException;
import com.example.financial_scheduler.transaction.dto.TransactionDTO;
import com.example.financial_scheduler.transaction.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    public List<TransactionDTO> findAll() {
        return service.findAll();
    }

    public void save(TransactionDTO transactionDTO) throws RuleException {
        service.save(transactionDTO);
    }

}
