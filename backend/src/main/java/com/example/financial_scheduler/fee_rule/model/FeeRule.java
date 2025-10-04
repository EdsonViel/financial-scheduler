package com.example.financial_scheduler.fee_rule.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "fee_rule")
@Data
public class FeeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long minDaysAhead;
    private Long maxDaysAhead;
    private Double feePercentage;

}
