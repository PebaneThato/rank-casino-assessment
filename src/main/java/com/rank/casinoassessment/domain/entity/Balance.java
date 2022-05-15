package com.rank.casinoassessment.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "balance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Balance  {
    @Id
    private Long id;

    private String userId;

    private String transactionId;

    private String transactionType;

    private BigDecimal balance;
}