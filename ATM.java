import java.util.Scanner;

// Class to manage account balance
class Account {
    private double balance;

    // Constructor to set starting balance
    Account(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful");
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful");
        }
    }

    // Method to print balance
    public void showBalance() {
        System.out.println("Balance: ₹" + balance);
    }
}

public class ATM {
    private static final int PIN = 1234;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account(2000); // Create account with 2000

        int attempts = 0;
        boolean authenticated = false;

        // Check PIN loop (max 3 tries)
        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (pin == PIN) {
                authenticated = true;
                break; // Stop loop if PIN is correct
            } else {
                System.out.println("Wrong PIN");
                attempts++;
            }
        }

        // Block user if authentication fails
        if (!authenticated) {
            System.out.println("Too many failed attempts. Card blocked.");
            return;
        }

        // Main menu options loop
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            // Menu selections
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                }

                case 2 -> {
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                }

                case 3 -> acc.showBalance();

                case 4 -> {
                    System.out.println("Thank you for using ATM!");
                    sc.close(); // Close scanner resource
                    return; // Close application
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}
