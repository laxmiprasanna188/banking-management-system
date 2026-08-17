package interfaces;

import exceptions.InvalidAmountException;
import model.Loan;

public interface LoanProcessing {

    void applyLoan(Loan loan)
            throws InvalidAmountException;

    void approveLoan(String loanId);

    void rejectLoan(String loanId);

    default void loanLog(String message) {
        System.out.println("LOAN LOG: " + message);
    }
}