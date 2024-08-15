package com.codedrop.repository;

import com.codedrop.entity.BankAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAmountRepository extends JpaRepository<BankAmount, Integer> {
}