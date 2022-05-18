package com.rank.casinoassessment.domain.repository;

import com.rank.casinoassessment.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTop10ByUsername(String username);
}