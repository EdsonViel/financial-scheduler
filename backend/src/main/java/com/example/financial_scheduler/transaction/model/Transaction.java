package com.example.financial_scheduler.transaction.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.financial_scheduler.account.model.Account;

import lombok.Data;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, targetEntity = Account.class, fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "source_account_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Account sourceAccount;

    @ManyToOne(optional = false, targetEntity = Account.class, fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "destination_account_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Account destinationAccount;

    @Column(name = "source_account_id", nullable = false)
    private Long sourceAccountId;

    @Column(name = "destination_account_id", nullable = false)
    private Long destinationAccountId;

    private Double amount;

    private Double fee;

    private LocalDate scheduledDate;

    private LocalDateTime createdAt;

}
