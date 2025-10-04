package com.example.financial_scheduler.fee_rule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financial_scheduler.fee_rule.model.FeeRule;

public interface FeeRuleRepository extends JpaRepository<FeeRule, Long> {

    Optional<FeeRule> findByMinDaysAheadLessThanEqualAndMaxDaysAheadGreaterThanEqual(Long minDaysAhead, Long maxDaysAhead);
}
