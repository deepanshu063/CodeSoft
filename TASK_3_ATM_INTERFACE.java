import java.util.Scanner;

public class TASK_3_ATM_INTERFACE {
    private EnhancedBankAccount bankAccount;
    private Scanner scanner;

    public TASK_3_ATM_INTERFACE(EnhancedBankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("Please choose an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
                showMenu();
        }
    }

    private void withdraw() {
        System.out.println("Enter the amount you would like to withdraw:");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
            showMenu();
            return;
        }
        if (amount > bankAccount.getBalance()) {
            System.out.println("Insufficient balance. Please enter an amount less than or equal to your current balance.");
            showMenu();
            return;
        }
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        System.out.println("Withdrawal successful. Your new balance is: " + bankAccount.getBalance());
        showMenu();
    }

    private void deposit() {
        System.out.println("Enter the amount you would like to deposit:");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
            showMenu();
            return;
        }
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        System.out.println("Deposit successful. Your new balance is: " + bankAccount.getBalance());
        showMenu();
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + bankAccount.getBalance());
        showMenu();
    }

    public static void main(String[] args) {
        EnhancedBankAccount bankAccount = new EnhancedBankAccount(1000);
        TASK_3_ATM_INTERFACE atm = new TASK_3_ATM_INTERFACE(bankAccount);
        atm.showMenu();
    }
}

class EnhancedBankAccount {
    private double balance;

    public EnhancedBankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
