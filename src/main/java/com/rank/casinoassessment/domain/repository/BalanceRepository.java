package com.rank.casinoassessment.domain.repository;

import com.rank.casinoassessment.domain.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
}