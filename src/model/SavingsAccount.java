package model;

public class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber,
                          double balance,
                          Customer customer) {

        super(accountNumber, balance, customer);
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}