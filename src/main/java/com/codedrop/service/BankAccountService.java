package com.codedrop.service;

import com.codedrop.model.BankAccount;

import java.util.List;

public interface BankAccountService {

    BankAccount findById(String id);

    List<BankAccount> findAll();

    BankAccount create(BankAccount bankAccount);

    BankAccount update(BankAccount bankAccount);

    void delete(String id);
}
