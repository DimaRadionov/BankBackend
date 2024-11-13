package com.example.fastrecklessbank.data;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class Account {
    private Integer id;
    private String name;
    private BigDecimal balance = BigDecimal.ZERO;
    private Deque<Transfer> outgoingTransfers = new LinkedList<>(); // Store transfer details

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(int id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public void addOutgoingTransfer(Transfer transferDetails) {
        if (outgoingTransfers.size() >= 50) {
            outgoingTransfers.removeFirst();
        }
        outgoingTransfers.addLast(transferDetails);
    }

    public Deque<Transfer> getOutgoingTransfers() {
        return outgoingTransfers;
    }
}
