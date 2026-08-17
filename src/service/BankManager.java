package service;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAccountException;
import exceptions.InvalidAmountException;
import interfaces.LoanProcessing;
import interfaces.TransactionService;
import model.Account;
import model.Customer;
import model.Loan;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankManager
        implements TransactionService, LoanProcessing {

    private List<Customer> customers;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private List<Loan> loans;

    private static int transactionCounter = 1000;

    public static final String BANK_NAME =
            "SRITW National Bank";

    public BankManager() {

        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
        loans = new ArrayList<>();
    }

    // =========================
    // CUSTOMER OPERATIONS
    // =========================

    public void addCustomer(Customer customer) {

        customers.add(customer);

        System.out.println(
                "Customer added successfully: "
                        + customer.getName());
    }

    public Customer findCustomer(String customerId) {

        for (Customer customer : customers) {

            if (customer.getCustomerId()
                    .equals(customerId)) {

                return customer;
            }
        }

        return null;
    }

    // =========================
    // ACCOUNT OPERATIONS
    // =========================

    public void addAccount(Account account) {

        accounts.add(account);

        System.out.println(
                "Account created successfully: "
                        + account.getAccountNumber());
    }

    public Account findAccount(String accountNumber)
            throws InvalidAccountException {

        for (Account account : accounts) {

            if (account.getAccountNumber()
                    .equals(accountNumber)) {

                return account;
            }
        }

        throw new InvalidAccountException(
                "Account not found: " + accountNumber);
    }

    // =========================
    // METHOD OVERLOADING
    // =========================

    public void deposit(String accountNumber,
                        double amount)
            throws InvalidAccountException,
            InvalidAmountException {

        Account account = findAccount(accountNumber);

        deposit(account, amount);
    }

    @Override
    public void deposit(Account account,
                         double amount)
            throws InvalidAmountException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero");
        }

        account.deposit(amount);

        createTransaction(
                account.getAccountNumber(),
                "DEPOSIT",
                amount);

        logTransaction(
                "Deposited ₹" + amount +
                        " into " +
                        account.getAccountNumber());
    }

    // =========================
    // WITHDRAW
    // =========================

    public void withdraw(String accountNumber,
                         double amount)
            throws InvalidAccountException,
            InvalidAmountException,
            InsufficientBalanceException {

        Account account = findAccount(accountNumber);

        withdraw(account, amount);
    }

    @Override
    public void withdraw(Account account,
                          double amount)
            throws InvalidAmountException,
            InsufficientBalanceException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero");
        }

        if (amount > account.getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance");
        }

        account.withdraw(amount);

        createTransaction(
                account.getAccountNumber(),
                "WITHDRAW",
                amount);

        logTransaction(
                "Withdrawn ₹" + amount +
                        " from " +
                        account.getAccountNumber());
    }

    // =========================
    // TRANSACTION
    // =========================

    private void createTransaction(
            String accountNumber,
            String type,
            double amount) {

        transactionCounter++;

        Transaction transaction =
                new Transaction(
                        "TXN" + transactionCounter,
                        accountNumber,
                        type,
                        amount);

        transactions.add(transaction);
    }

    public void showTransactions() {

        if (transactions.isEmpty()) {

            System.out.println(
                    "No transactions found.");

            return;
        }

        System.out.println(
                "\n===== TRANSACTIONS =====");

        for (Transaction transaction :
                transactions) {

            System.out.println(transaction);
        }
    }

    // =========================
    // LOAN OPERATIONS
    // =========================

    @Override
    public void applyLoan(Loan loan)
            throws InvalidAmountException {

        if (loan.getAmount() <= 0) {

            throw new InvalidAmountException(
                    "Loan amount must be greater than zero");
        }

        loans.add(loan);

        loanLog(
                "Loan applied: "
                        + loan.getLoanId());
    }

    @Override
    public void approveLoan(String loanId) {

        for (Loan loan : loans) {

            if (loan.getLoanId()
                    .equals(loanId)) {

                loan.setStatus("APPROVED");

                loanLog(
                        "Loan approved: "
                                + loanId);

                return;
            }
        }

        System.out.println(
                "Loan not found.");
    }

    @Override
    public void rejectLoan(String loanId) {

        for (Loan loan : loans) {

            if (loan.getLoanId()
                    .equals(loanId)) {

                loan.setStatus("REJECTED");

                loanLog(
                        "Loan rejected: "
                                + loanId);

                return;
            }
        }

        System.out.println(
                "Loan not found.");
    }

    public void showLoans() {

        if (loans.isEmpty()) {

            System.out.println(
                    "No loans found.");

            return;
        }

        System.out.println(
                "\n===== LOANS =====");

        for (Loan loan : loans) {

            System.out.println(loan);
        }
    }

    // =========================
    // REPORT
    // =========================

    public void showCustomers() {

        System.out.println(
                "\n===== CUSTOMERS =====");

        if (customers.isEmpty()) {

            System.out.println(
                    "No customers found.");

            return;
        }

        for (Customer customer :
                customers) {

            System.out.println(
                    customer);
        }
    }

    public void showAccounts() {

        System.out.println(
                "\n===== ACCOUNTS =====");

        if (accounts.isEmpty()) {

            System.out.println(
                    "No accounts found.");

            return;
        }

        for (Account account :
                accounts) {

            System.out.println(account);
        }
    }

    // Static method
    public static int getTransactionCount() {

        return transactionCounter - 1000;
    }

    // Method overloading
    public void showBankInfo() {

        System.out.println(
                "Bank: " + BANK_NAME);
    }

    public void showBankInfo(String message) {

        System.out.println(
                BANK_NAME + " - " + message);
    }
}