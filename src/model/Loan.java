package model;

public class Loan {

    private String loanId;
    private Customer customer;
    private double amount;
    private String loanType;
    private String status;

    public Loan(String loanId,
                Customer customer,
                double amount,
                String loanType) {

        this.loanId = loanId;
        this.customer = customer;
        this.amount = amount;
        this.loanType = loanType;
        this.status = "PENDING";
    }

    public String getLoanId() {
        return loanId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Loan ID: " + loanId +
                ", Customer: " + customer.getName() +
                ", Amount: " + amount +
                ", Type: " + loanType +
                ", Status: " + status;
    }
}