package com.rank.casinoassessment.service;

import com.rank.casinoassessment.entity.Balance;
import com.rank.casinoassessment.entity.Transaction;
import com.rank.casinoassessment.repository.BalanceRepository;
import com.rank.casinoassessment.repository.TransactionRepository;
import com.rank.casinoassessment.exception.RankCasinoBadRequestException;
import com.rank.casinoassessment.exception.RankCasinoTeapotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CasinoBalanceTransactionService {
    enum TransactionType {
        WIN,
        WAGER
    }
    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public Balance getBalanceByPlayerId(Integer playerId) {
        Balance balance = balanceRepository.findFirstByPlayerId(playerId);
        if (balance == null) {
            throw new RankCasinoBadRequestException("No balance that matches player Id " + playerId);
        }
        return balance;
    }

    @Transactional
    public Balance updateBalance(Integer playerId, BigDecimal amount, String transactionType) {
        Balance currentBalance = getBalanceByPlayerId(playerId);
        if(transactionType != null && transactionType.equalsIgnoreCase(TransactionType.WAGER.name()) && amount.compareTo(currentBalance.getBalance()) > 0 )
            throw new RankCasinoTeapotException("Wager amount can not be greater than current balance");
        currentBalance.setBalance(amount);
        currentBalance.setTransactionType(transactionType);
        return balanceRepository.save(currentBalance);
    }

    public List<Transaction> findTop10ByUsername(String username){
        List<Transaction> transactions = transactionRepository.findTop10ByUsername(username);
        if(transactions.isEmpty())
            throw new RankCasinoBadRequestException("No transactions found for username " + username);
        return transactions;
    }
}
