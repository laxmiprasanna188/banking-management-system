package model;

public abstract class Account {

    private String accountNumber;
    private double balance;
    private Customer customer;

    public Account(String accountNumber,
                   double balance,
                   Customer customer) {

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
    }

    // Abstract method
    public abstract String getAccountType();

    public abstract double calculateInterest();

    @Override
    public String toString() {

        return "Account Number: " + accountNumber +
                ", Type: " + getAccountType() +
                ", Balance: " + balance;
    }
}