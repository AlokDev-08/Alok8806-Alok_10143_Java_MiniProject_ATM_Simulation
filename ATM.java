import java.util.*;

class Account {
     double balance = 2000;
 
     void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount"); 
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;  
            System.out.println("Transaction successful");
        }
    }

     void showBalance() {
        System.out.println("Balance: " + balance);
    }
}

class ATM {
    static int PIN = 1234;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (pin != PIN) {
            System.out.println("Wrong PIN");
            return;
        }

        while (true) {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    acc.withdraw(amt);
                    break;

                case 2:
                    acc.showBalance();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
