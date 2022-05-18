package com.rank.casinoassessment.controller;

import com.rank.casinoassessment.domain.entity.Balance;
import com.rank.casinoassessment.domain.entity.Transaction;
import com.rank.casinoassessment.service.CasinoBalanceTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public ResponseEntity<Balance> getBalanceById(@PathVariable(value = "playerId") String playerId) {
        Optional<Balance> balanceOpt = casinoBalanceTransactionService.getBalanceByPlayerId(playerId);
        return balanceOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/player/{playerId}/balance/update")
    public Balance updateBalanceByPlayerId(@PathVariable(value = "playerId") String playerId) {
        Balance balanceOpt = casinoBalanceTransactionService.updateBalance(playerId, new BigDecimal("0.01"), "win");
        return balanceOpt;
    }

    @PostMapping("/admin/player/transactions")
    public List<Transaction> getAccounts() {
        return casinoBalanceTransactionService.findTop10ByUsername("player09");
    }

}