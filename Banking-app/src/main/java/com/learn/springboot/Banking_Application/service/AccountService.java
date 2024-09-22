package com.learn.springboot.Banking_Application.service;

import com.learn.springboot.Banking_Application.model.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountByNo(Long accountNo);

    Account deposit(Long accountNo, double amount);

    Account withdraw(Long accountNo, double amount);

    List<Account> getAllAccounts();

    void deleteAccount(Long accountNo);
}
