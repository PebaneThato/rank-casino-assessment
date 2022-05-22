package com.rank.casinoassessment.dto;

import com.rank.casinoassessment.entity.Balance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBalanceResponse {
    private BigInteger transactionId;
    private BigDecimal balance;

    public UpdateBalanceResponse(Balance balance){
        this.transactionId = balance.getTransactionId();
        this.balance = balance.getBalance();
    }
}
