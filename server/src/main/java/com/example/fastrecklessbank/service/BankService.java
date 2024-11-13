package com.example.fastrecklessbank.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.example.fastrecklessbank.data.Account;
import com.example.fastrecklessbank.data.Transfer;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BankService {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int transferId = 1;

    public Account createAccount(Account account) {
        int id = (int) (1 + (Math.random() * 1000));
        account.setId(id);
        accounts.put(id, account);
        log.info(accounts.toString());
        return account;

    }

    public void deposit(int accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        account.deposit(amount);
    }

    public void withdraw(int accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.withdraw(amount);
    }

    public void transfer(int fromAccountId, int toAccountId, BigDecimal amount) {
        if (fromAccountId == toAccountId) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        Account fromAccount = getAccount(fromAccountId);
        Account toAccount = getAccount(toAccountId);

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds for transfer");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        Transfer transferDetails = new Transfer(Integer.toString(transferId), "transfer", LocalDate.now(), amount);
        fromAccount.addOutgoingTransfer(transferDetails);
        transferId++;
    }

    private Account getAccount(int accountId) {
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        return account;
    }

    public Map<String, List<Account>> getAllAccounts(){
        log.info(accounts.toString());
        List<Account> accountList = new ArrayList<>(accounts.values()); // Преобразуем Map в List
        Map<String, List<Account>> response = new HashMap<>();
        response.put("list", accountList);
        return response;
    }
}
