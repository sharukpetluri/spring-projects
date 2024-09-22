package com.learn.springboot.Banking_Application.controller;

import com.learn.springboot.Banking_Application.model.Account;
import com.learn.springboot.Banking_Application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/banking/accounts")
public class AccountController {

   private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // REST API to 'CREATE' Account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    // REST API to 'GET' Account
    @GetMapping("/search/{accountNo}")
    public ResponseEntity<Account> getAccountByNo(@PathVariable Long accountNo) {
        return new ResponseEntity<>(accountService.getAccountByNo(accountNo), HttpStatus.FOUND);
    }

    //REST API to 'DEPOSIT' Amount
    @PutMapping("/{accountNo}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long accountNo, @RequestBody Map<String, Double> request) {
        return new ResponseEntity<>(accountService.deposit(accountNo, request.get("amount")), HttpStatus.OK);
    }

    //REST API to 'WITHDRAW' Amount
    @PutMapping("/{accountNo}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long accountNo, @RequestBody Map<String, Double> request) {
        return new ResponseEntity<>(accountService.withdraw(accountNo, request.get("amount")), HttpStatus.OK);
    }

    //REST API to 'GET All Accounts'
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //REST API to 'DELETE' Account
    @DeleteMapping("/{accountNo}/delete")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNo) {
        accountService.deleteAccount(accountNo);
        return ResponseEntity.ok("Account is deleted successfully");
    }

}