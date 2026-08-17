package model;

import java.time.LocalDateTime;

public class Transaction {

    private String transactionId;
    private String accountNumber;
    private String type;
    private double amount;
    private LocalDateTime date;

    public Transaction(String transactionId,
                       String accountNumber,
                       String type,
                       double amount) {

        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {

        return "Transaction ID: " + transactionId +
                ", Account: " + accountNumber +
                ", Type: " + type +
                ", Amount: " + amount +
                ", Date: " + date;
    }
}