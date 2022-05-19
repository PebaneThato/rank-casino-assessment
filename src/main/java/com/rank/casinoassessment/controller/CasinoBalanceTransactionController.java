package com.rank.casinoassessment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rank.casinoassessment.domain.entity.Balance;
import com.rank.casinoassessment.domain.entity.Transaction;
import com.rank.casinoassessment.dto.*;
import com.rank.casinoassessment.service.CasinoBalanceTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/casino")
public class CasinoBalanceTransactionController {

    private final CasinoBalanceTransactionService casinoBalanceTransactionService;

    public CasinoBalanceTransactionController(CasinoBalanceTransactionService casinoBalanceTransactionService) {
        this.casinoBalanceTransactionService = casinoBalanceTransactionService;
    }

    @GetMapping("/player/{playerId}/balance")
    public GetBalanceResponse getBalanceById(@PathVariable(value = "playerId") String playerId) {
        int playerIdValue = Integer.parseInt(playerId);
        Balance balance = casinoBalanceTransactionService.getBalanceByPlayerId(playerIdValue);
        return new GetBalanceResponse(balance);
    }

    @PostMapping("/player/{playerId}/balance/update")
    public UpdateBalanceResponse updateBalanceByPlayerId(@PathVariable(value = "playerId") String playerId, @RequestBody UpdateBalanceRequest updateBalanceRequest) {
        int playerIdValue = Integer.parseInt(playerId);
        Balance balance = casinoBalanceTransactionService.updateBalance(playerIdValue, new BigDecimal(updateBalanceRequest.getAmount()), updateBalanceRequest.getTransactionType());
        return new UpdateBalanceResponse(balance);
    }

    @PostMapping("/admin/player/transactions")
    public List<last10TXTResponse> getLast10ByUsername(@RequestBody Last10TXTRequest last10TXTRequest) {
        List<Transaction> transactions = casinoBalanceTransactionService.findTop10ByUsername(last10TXTRequest.getUsername());
        ObjectMapper mapper = new ObjectMapper();
        return transactions.stream()
                .map(object -> new last10TXTResponse(object))
                .collect(Collectors.toList());
    }

}