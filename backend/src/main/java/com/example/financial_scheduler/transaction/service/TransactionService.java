package com.example.financial_scheduler.transaction.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.financial_scheduler.common.exceptions.RuleException;
import com.example.financial_scheduler.fee_rule.model.FeeRule;
import com.example.financial_scheduler.fee_rule.repository.FeeRuleRepository;
import com.example.financial_scheduler.transaction.dto.TransactionDTO;
import com.example.financial_scheduler.transaction.dto.TransactionListDTO;
import com.example.financial_scheduler.transaction.model.Transaction;
import com.example.financial_scheduler.transaction.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private FeeRuleRepository feeRuleRepository;

    public Page<TransactionListDTO> findAll(Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();

        
        return repository.findAll(pageable)
                .map(entity -> modelMapper.map(entity, TransactionListDTO.class));
    }

    public void save(TransactionDTO transactionDTO) throws RuleException {
        ModelMapper modelMapper = new ModelMapper();
        
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);

        LocalDate createdTransactionDate = LocalDate.now();
        LocalDate scheduledTransactionDate = transaction.getScheduledDate();
        Long daysAhead = ChronoUnit.DAYS.between(createdTransactionDate, scheduledTransactionDate);

        Optional<FeeRule> feeRuleOpt = feeRuleRepository.findByMinDaysAheadLessThanEqualAndMaxDaysAheadGreaterThanEqual(daysAhead, daysAhead);

        if (feeRuleOpt.isPresent()) {
            
            FeeRule feeRule = feeRuleOpt.get();
            
            if (feeRule.getFeePercentage() == null || feeRule.getFeePercentage().equals(0.0)) {
                //throw new RuleException("Fee percentage not defined in the rule.");
                throw new RuleException("Percentual da taxa não definida na regra.");
            }

            if (transaction.getAmount() == null || transaction.getAmount().equals(0.0)) {
                //throw new RuleException("Transaction amount not defined.");
                throw new RuleException("Valor da transação não definido.");
            }

            transaction.setFee(feeRule.getFeePercentage());

            Double feeAmount = transaction.getAmount() * feeRule.getFeePercentage() / 100;
            transaction.setFee(feeAmount);
            LocalDateTime now = LocalDateTime.now();
            transaction.setCreatedAt(now);

            repository.save(transaction);

        } else {
            //throw new RuleException("No fee rule found for the given days ahead: " + daysAhead);
            throw new RuleException("Nenhuma regra de taxa encontrada para os dias a frente: " + daysAhead);
        }

    }

}
