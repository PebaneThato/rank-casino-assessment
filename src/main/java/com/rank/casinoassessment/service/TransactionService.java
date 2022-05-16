package com.rank.casinoassessment.service;

import com.rank.casinoassessment.domain.entity.Transaction;
import com.rank.casinoassessment.domain.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Optional<Transaction> getTransactionById(Long transactionId) {
        return  transactionRepository.findById(transactionId);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}