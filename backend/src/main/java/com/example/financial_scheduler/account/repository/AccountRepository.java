package com.example.financial_scheduler.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financial_scheduler.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByIdNot(Long id);

}
