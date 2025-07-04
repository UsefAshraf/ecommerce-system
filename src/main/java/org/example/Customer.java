package org.example;

public class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean canPay(double amount) {
        return balance >= amount;
    }

    public void pay(double amount) {
        balance -= amount;
    }
}
