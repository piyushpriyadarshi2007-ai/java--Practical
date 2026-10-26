import bank.Account;
import bank.InsufficientFundsException;
import bank.InvalidAmountException;
import java.util.Scanner;

public class Practical6 {
    public static void main(String[] args) {
        Account a = new Account(2000);
        Account b = new Account(1000);
        System.out.println("Total accounts (static): " + Account.getTotalAccounts());
        System.out.println("Min balance (final): " + Account.MIN_BALANCE);

        try {
            a.deposit(500);
            a.withdraw(1000);
            System.out.println("A balance: " + a.getBalance());
            b.withdraw(800);                      
        } catch (InsufficientFundsException e) {
            System.out.println("Domain error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt finished (finally always runs).");
        }

        try { new Account(100); }
        catch (InvalidAmountException e) { System.out.println("Invalid input: " + e.getMessage()); }

        try { a.deposit(-50); }
        catch (InvalidAmountException e) { System.out.println("Invalid input: " + e.getMessage()); }

        // Invalid user input handling
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        try {
            double amt = Double.parseDouble(sc.hasNextLine() ? sc.nextLine() : "abc");
            a.deposit(amt);
            System.out.println("New balance: " + a.getBalance());
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number!");
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

