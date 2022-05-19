package com.rank.casinoassessment.domain.repository;

import com.rank.casinoassessment.domain.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
    Balance findFirstByPlayerId(Integer playerId);
}