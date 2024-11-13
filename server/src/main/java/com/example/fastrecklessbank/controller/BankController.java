package com.example.fastrecklessbank.controller;

import com.example.fastrecklessbank.data.Account;
import com.example.fastrecklessbank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/bank")
@CrossOrigin(origins = "http://localhost:3001")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/create-account")
    public Account createAccount(@RequestBody Account account) {
        return bankService.createAccount(account);
    }

    @PostMapping("/deposit")
    public void deposit(@RequestParam int accountId, @RequestParam BigDecimal amount) {
        bankService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam int accountId, @RequestParam BigDecimal amount) {
        bankService.withdraw(accountId, amount);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestParam int fromAccountId, @RequestParam int toAccountId, @RequestParam BigDecimal amount) {
        bankService.transfer(fromAccountId, toAccountId, amount);
    }

    @GetMapping("/listAccounts")
    public Map<String, List<Account>> listAccounts(){
       return bankService.getAllAccounts();
    }
}
