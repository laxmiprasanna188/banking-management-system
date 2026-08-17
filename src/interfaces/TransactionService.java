package interfaces;

import exceptions.InvalidAmountException;
import exceptions.InsufficientBalanceException;
import model.Account;

public interface TransactionService {

    void deposit(Account account, double amount)
            throws InvalidAmountException;

    void withdraw(Account account, double amount)
            throws InvalidAmountException, InsufficientBalanceException;

    default void logTransaction(String message) {
        System.out.println("TRANSACTION LOG: " + message);
    }
}