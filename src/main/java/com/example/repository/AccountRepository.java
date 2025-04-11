package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Account;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer>{ 
    public boolean existsByUsername(String username);
    public Optional<Account> findByUsername(String username);
}
