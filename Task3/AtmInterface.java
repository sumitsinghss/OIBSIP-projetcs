import java.util.Scanner;

public class AtmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount("Sumit Singh Rathore", "1234567890", 1000.0);

        System.out.println("Welcome to the ATM!");
        System.out.println("Account Holder: " + bankAccount.getAccountHolder());
        System.out.println("Account Number: " + bankAccount.getAccountNumber());

        boolean exit = false;

        while (!exit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        bankAccount.deposit(depositAmount);
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > 0) {
                        if (bankAccount.getBalance() >= withdrawalAmount) {
                            bankAccount.withdraw(withdrawalAmount);
                            System.out.println("Withdrawal successful!");
                        } else {
                            System.out.println("Insufficient funds!");
                        }
                    } else {
                        System.out.println("Invalid withdrawal amount!");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}

class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
