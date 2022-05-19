package com.rank.casinoassessment.dto;

import com.rank.casinoassessment.domain.entity.Balance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetBalanceResponse {
    private int playerId;
    private BigDecimal balance;
    public GetBalanceResponse(Balance balance){
        this.playerId = balance.getPlayerId();
        this.balance = balance.getBalance();
    }
}
