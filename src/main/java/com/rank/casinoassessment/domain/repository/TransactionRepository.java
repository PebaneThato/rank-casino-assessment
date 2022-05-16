package com.rank.casinoassessment.domain.repository;

import com.rank.casinoassessment.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}