package com.example.service;
import org.springframework.stereotype.Service;

import com.example.repository.AccountRepository;

@Service
public class MessageService 
{
    public MessageService(AccountRepository passedInRepo)
    {
        phil = passedInRepo;
    }
    private final AccountRepository phil;
}
