package com.learn.springboot.Banking_Application.service;

import com.learn.springboot.Banking_Application.model.Account;
import com.learn.springboot.Banking_Application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account getAccountByNo(Long accountNo) {
        return accountRepo.findById(accountNo).orElseThrow(() -> new RuntimeException("Account with number " + accountNo + " does not exist"));
    }

    @Override
    public Account deposit(Long accountNo, double amount) {
        Account account = accountRepo.findById(accountNo).orElseThrow(
                () -> new RuntimeException("Cannot deposit.. as Account with number " + accountNo + " does not exist"));
        double total = amount + account.getAccountBalance();
        account.setAccountBalance(total);
        return accountRepo.save(account);
    }

    @Override
    public Account withdraw(Long accountNo, double amount) {

        Account account = accountRepo.findById(accountNo).orElseThrow(
                () -> new RuntimeException("Cannot withdraw.. as Account with number " + accountNo + " does not exist"));

        if(account.getAccountBalance() < amount){
            throw new RuntimeException("Insufficient Balance");
        }

        double total = account.getAccountBalance() - amount;
        account.setAccountBalance(total);

        return accountRepo.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public void deleteAccount(Long accountNo) {
        accountRepo.deleteById(accountNo);
    }

}