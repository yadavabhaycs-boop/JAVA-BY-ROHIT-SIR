// Custom exception for insufficient balance

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom exception for invalid deposit amount
class InvalidDepositException extends Exception {

    public InvalidDepositException(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    // Method to deposit money
    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0) {
            throw new InvalidDepositException("Deposit amount must be greater than zero.");
        }

        balance += amount;
        System.out.println("Successfully deposited: " + amount);
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }

        balance -= amount;
        System.out.println("Successfully withdrawn: " + amount);
    }

    // Method to display balance
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

// Main class
public class P3S120 {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000);

        try {
            account.displayBalance();

            account.deposit(50000);

            account.withdraw(60000);

        } catch (InvalidDepositException e) {

            System.out.println("Deposit Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {

            System.out.println("Withdrawal Error: " + e.getMessage());
        }

        try {

            account.deposit(-1000);

        } catch (InvalidDepositException e) {

            System.out.println("Deposit Error: " + e.getMessage());
        }

        account.displayBalance();
    }
}
