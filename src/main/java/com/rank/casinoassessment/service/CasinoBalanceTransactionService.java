package com.rank.casinoassessment.service;

import com.rank.casinoassessment.domain.entity.Balance;
import com.rank.casinoassessment.domain.entity.Transaction;
import com.rank.casinoassessment.domain.repository.BalanceRepository;
import com.rank.casinoassessment.domain.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CasinoBalanceTransactionService {
    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public Optional<Balance> getBalanceById(Long balanceId) {
        return  balanceRepository.findById(balanceId);
    }

    public List<Balance> getBalances() {
        return balanceRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long transactionId) {
        return  transactionRepository.findById(transactionId);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}
