package com.example.financial_scheduler.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financial_scheduler.account.dto.AccountDTO;
import com.example.financial_scheduler.account.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public List<AccountDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/exclude/{id}")
    public List<AccountDTO> findAllExcludingId(@PathVariable Long id) {
        return service.findAllByIdNot(id);
    }

}
