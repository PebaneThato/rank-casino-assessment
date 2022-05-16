package com.rank.casinoassessment.service;

import com.rank.casinoassessment.domain.entity.Balance;
import com.rank.casinoassessment.domain.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    public Optional<Balance> getBalanceById(Long balanceId) {
        return  balanceRepository.findById(balanceId);
    }

    public List<Balance> getBalances() {
        return balanceRepository.findAll();
    }
}