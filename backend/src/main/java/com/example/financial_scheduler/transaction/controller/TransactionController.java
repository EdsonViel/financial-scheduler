package com.example.financial_scheduler.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.financial_scheduler.common.exceptions.RuleException;
import com.example.financial_scheduler.transaction.dto.TransactionDTO;
import com.example.financial_scheduler.transaction.dto.TransactionListDTO;
import com.example.financial_scheduler.transaction.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @Transactional(readOnly = true)
    @GetMapping
    public Page<TransactionListDTO> findAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "25") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.findAll(pageable);
    }

    @Transactional
    @PostMapping
    public void save(@RequestBody TransactionDTO transactionDTO) throws RuleException {
        
        service.save(transactionDTO);
    }

}
