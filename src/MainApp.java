import exceptions.InsufficientBalanceException;
import exceptions.InvalidAccountException;
import exceptions.InvalidAmountException;
import java.util.Scanner;
import model.Account;
import model.Address;
import model.Customer;
import model.Loan;
import model.SavingsAccount;
import service.BankManager;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankManager bank = new BankManager();
        //my test changes
        // Sample customer
        Address address =
                new Address(
                        "Warangal",
                        "Telangana",
                        "506001");

        Customer customer =
                new Customer(
                        "Laxmi",
                        21,
                        "C001",
                        "9876543210",
                        address);

        bank.addCustomer(customer);

        // Sample account
        Account account =
                new SavingsAccount(
                        "ACC1001",
                        10000,
                        customer);

        bank.addAccount(account);

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("       BANKING MANAGEMENT SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Add Customer");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Show Customers");
            System.out.println("6. Show Accounts");
            System.out.println("7. Show Transactions");
            System.out.println("8. Apply Loan");
            System.out.println("9. Show Loans");
            System.out.println("10. Approve Loan");
            System.out.println("11. Reject Loan");
            System.out.println("12. Show Bank Information");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();

            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print(
                                "Enter name: ");

                        String name =
                                scanner.nextLine();

                        System.out.print(
                                "Enter age: ");

                        int age =
                                scanner.nextInt();

                        scanner.nextLine();

                        System.out.print(
                                "Enter customer ID: ");

                        String customerId =
                                scanner.nextLine();

                        System.out.print(
                                "Enter phone: ");

                        String phone =
                                scanner.nextLine();

                        System.out.print(
                                "Enter city: ");

                        String city =
                                scanner.nextLine();

                        System.out.print(
                                "Enter state: ");

                        String state =
                                scanner.nextLine();

                        System.out.print(
                                "Enter pincode: ");

                        String pincode =
                                scanner.nextLine();

                        Address newAddress =
                                new Address(
                                        city,
                                        state,
                                        pincode);

                        Customer newCustomer =
                                new Customer(
                                        name,
                                        age,
                                        customerId,
                                        phone,
                                        newAddress);

                        bank.addCustomer(
                                newCustomer);

                        break;

                    case 2:

                        System.out.print(
                                "Enter customer ID: ");

                        String cid =
                                scanner.nextLine();

                        Customer foundCustomer =
                                bank.findCustomer(cid);

                        if (foundCustomer == null) {

                            System.out.println(
                                    "Customer not found.");

                            break;
                        }

                        System.out.print(
                                "Enter account number: ");

                        String accNo =
                                scanner.nextLine();

                        System.out.print(
                                "Enter initial balance: ");

                        double balance =
                                scanner.nextDouble();

                        Account newAccount =
                                new SavingsAccount(
                                        accNo,
                                        balance,
                                        foundCustomer);

                        bank.addAccount(
                                newAccount);

                        break;

                    case 3:

                        System.out.print(
                                "Enter account number: ");

                        String depositAccount =
                                scanner.nextLine();

                        System.out.print(
                                "Enter amount: ");

                        double depositAmount =
                                scanner.nextDouble();

                        bank.deposit(
                                depositAccount,
                                depositAmount);

                        System.out.println(
                                "Deposit successful.");

                        break;

                    case 4:

                        System.out.print(
                                "Enter account number: ");

                        String withdrawAccount =
                                scanner.nextLine();

                        System.out.print(
                                "Enter amount: ");

                        double withdrawAmount =
                                scanner.nextDouble();

                        bank.withdraw(
                                withdrawAccount,
                                withdrawAmount);

                        System.out.println(
                                "Withdrawal successful.");

                        break;

                    case 5:

                        bank.showCustomers();

                        break;

                    case 6:

                        bank.showAccounts();

                        break;

                    case 7:

                        bank.showTransactions();

                        break;

                    case 8:

                        System.out.print(
                                "Enter loan ID: ");

                        String loanId =
                                scanner.nextLine();

                        System.out.print(
                                "Enter customer ID: ");

                        String loanCustomerId =
                                scanner.nextLine();

                        Customer loanCustomer =
                                bank.findCustomer(
                                        loanCustomerId);

                        if (loanCustomer == null) {

                            System.out.println(
                                    "Customer not found.");

                            break;
                        }

                        System.out.print(
                                "Enter loan amount: ");

                        double loanAmount =
                                scanner.nextDouble();

                        scanner.nextLine();

                        System.out.print(
                                "Enter loan type: ");

                        String loanType =
                                scanner.nextLine();

                        Loan loan =
                                new Loan(
                                        loanId,
                                        loanCustomer,
                                        loanAmount,
                                        loanType);

                        bank.applyLoan(loan);

                        System.out.println(
                                "Loan application submitted.");

                        break;

                    case 9:

                        bank.showLoans();

                        break;

                    case 10:

                        System.out.print(
                                "Enter loan ID: ");

                        String approveId =
                                scanner.nextLine();

                        bank.approveLoan(
                                approveId);

                        break;

                    case 11:

                        System.out.print(
                                "Enter loan ID: ");

                        String rejectId =
                                scanner.nextLine();

                        bank.rejectLoan(
                                rejectId);

                        break;

                    case 12:

                        bank.showBankInfo(
                                "Welcome to our banking system!");

                        System.out.println(
                                "Total transactions: "
                                        + BankManager
                                        .getTransactionCount());

                        break;

                    case 0:

                        System.out.println(
                                "Thank you for using "
                                        + "Banking Management System!");

                        break;

                    default:

                        System.out.println(
                                "Invalid choice.");
                }

            } catch (InvalidAccountException |
                     InvalidAmountException |
                     InsufficientBalanceException e) {

                System.out.println(
                        "ERROR: " + e.getMessage());
            }

        } while (choice != 0);

        scanner.close();
    }
}