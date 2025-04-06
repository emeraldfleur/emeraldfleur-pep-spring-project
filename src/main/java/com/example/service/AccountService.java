package com.example.service;
import org.springframework.stereotype.Service;

import com.example.repository.AccountRepository;

@Service
public class AccountService 
{
    public AccountService(AccountRepository passedInRepo)
    {
        bob = passedInRepo;
    }
    private final AccountRepository bob;

}
