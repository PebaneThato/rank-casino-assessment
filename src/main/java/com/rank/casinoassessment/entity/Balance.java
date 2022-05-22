package com.rank.casinoassessment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "balance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Balance  {
    @Id
    private Long id;

    private int playerId;

    private BigInteger transactionId;

    private String transactionType;

    private BigDecimal balance;
}