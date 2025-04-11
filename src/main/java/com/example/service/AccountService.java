package com.example.service;
import org.springframework.stereotype.Service;
import com.example.entity.Account;
import com.example.exception.DuplicateUsernameException;
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
        String password = account.getPassword();
        if(username == null || username.isBlank())
        {
            throw new IllegalArgumentException("Username is empty or null.");
        }
        if(password == null || (password.length() < 4))
        {
            throw new IllegalArgumentException("Password is empty, null, or less than 4.");
        }
        if(bob.existsByUsername(username))
        {
            throw new DuplicateUsernameException();
        }
        else
        {
            
        }
        return null;
    }

}
