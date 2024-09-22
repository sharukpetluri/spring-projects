package com.learn.springboot.Banking_Application.repository;

import com.learn.springboot.Banking_Application.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
