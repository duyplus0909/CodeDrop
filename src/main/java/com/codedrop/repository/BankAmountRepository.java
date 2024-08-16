package com.codedrop.repository;

import com.codedrop.model.BankAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAmountRepository extends JpaRepository<BankAmount, Integer> {
}