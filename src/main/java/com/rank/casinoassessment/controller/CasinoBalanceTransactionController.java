package com.rank.casinoassessment.controller;

import com.rank.casinoassessment.domain.entity.Balance;
import com.rank.casinoassessment.domain.entity.Transaction;
import com.rank.casinoassessment.service.CasinoBalanceTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/casino")
public class CasinoBalanceTransactionController {

    private final CasinoBalanceTransactionService casinoBalanceTransactionService;

    public CasinoBalanceTransactionController(CasinoBalanceTransactionService casinoBalanceTransactionService) {
        this.casinoBalanceTransactionService = casinoBalanceTransactionService;
    }

    @GetMapping("/player/{playerId}/balance")
    public ResponseEntity<Balance> getBalanceById(@PathVariable(value = "playerId") Long playerId) {
        Optional<Balance> accountOpt = casinoBalanceTransactionService.getBalanceById(playerId);
        return accountOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/balance/list")
    public List<Balance> getAccounts() {
        return casinoBalanceTransactionService.getBalances();
    }

}