package model;

public class CurrentAccount extends Account {

    private static final double MINIMUM_BALANCE = 5000;

    public CurrentAccount(String accountNumber,
                          double balance,
                          Customer customer) {

        super(accountNumber, balance, customer);
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public boolean hasMinimumBalance() {
        return getBalance() >= MINIMUM_BALANCE;
    }
}