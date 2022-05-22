package com.rank.casinoassessment.dto;

import com.rank.casinoassessment.entity.Transaction;
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
public class last10TXTResponse {
    private String transactionType;
    private BigInteger transactionId;
    private BigDecimal amount;

    public last10TXTResponse(Transaction transaction){
        this.transactionType = transaction.getTransactionType();
        this.transactionId = transaction.getTransactionId();
        this.amount = transaction.getAmount();
    }
}
