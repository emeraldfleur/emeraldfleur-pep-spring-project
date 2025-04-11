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
        accountRepo = passedInRepository;
    }
    private final AccountRepository accountRepo;

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
        if(accountRepo.existsByUsername(username))
        {
            throw new DuplicateUsernameException();
        }
        else
        {
            Account phil = new Account(username, password);
            phil = accountRepo.save(phil);
            return phil;
        }
    }

}
