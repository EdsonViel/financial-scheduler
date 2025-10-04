package com.example.financial_scheduler.transaction.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financial_scheduler.transaction.dto.TransactionDTO;
import com.example.financial_scheduler.transaction.model.Transaction;
import com.example.financial_scheduler.transaction.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<TransactionDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(repository.findAll(), new TypeToken<List<TransactionDTO>>() {}.getType());
    }

    public TransactionDTO save(TransactionDTO transactionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);

        //TODO: Add fee calculation logic here

        return modelMapper.map(repository.save(transaction), TransactionDTO.class);
    }

}
