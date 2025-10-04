package com.example.financial_scheduler.account.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financial_scheduler.account.dto.AccountDTO;
import com.example.financial_scheduler.account.model.Account;
import com.example.financial_scheduler.account.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<AccountDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(repository.findAll(), new TypeToken<List<AccountDTO>>() {}.getType());
    }

    public List<AccountDTO> findAllByIdNot(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(repository.findAllByIdNot(id), new TypeToken<List<AccountDTO>>() {}.getType());
    }

    public AccountDTO save(AccountDTO accountDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(repository.save(modelMapper.map(accountDTO, Account.class)), AccountDTO.class);
    }

}
