package com.example.financial_scheduler.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financial_scheduler.transaction.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
