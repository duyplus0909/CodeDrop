package com.codedrop.repository;

import com.codedrop.model.BankHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankHistoryRepository extends JpaRepository<BankHistory, Integer> {
}