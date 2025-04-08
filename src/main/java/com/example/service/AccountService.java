package com.example.service;
import org.springframework.stereotype.Service;
import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService 
{
    public AccountService(AccountRepository passedInRepository)
    {
        bob = passedInRepository;
    }
    private final AccountRepository bob;

    public Account registerAccount(Account account)
    {
        String username = account.getUsername();
        if(username.isEmpty() || username == null)
        {
        }
        return null;
    }
}
