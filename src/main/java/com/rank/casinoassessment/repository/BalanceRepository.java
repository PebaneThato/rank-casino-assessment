package com.rank.casinoassessment.repository;

import com.rank.casinoassessment.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
    Balance findFirstByPlayerId(Integer playerId);
}