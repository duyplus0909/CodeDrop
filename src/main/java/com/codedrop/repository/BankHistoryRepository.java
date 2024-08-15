package com.codedrop.repository;

import com.codedrop.entity.BankHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankHistoryRepository extends JpaRepository<BankHistory, Integer> {
}