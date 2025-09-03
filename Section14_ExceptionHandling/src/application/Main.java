package application;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        String holder = sc.next();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account ac = new Account(number, holder, initialBalance, withdrawLimit);

        System.out.print("\nEnter amount for withdraw: ");
        double amount = sc.nextDouble();

        try {
            ac.withdraw(amount);
        } catch (WithdrawException e) {
            System.err.println("Withdraw error: " + e.getMessage());
        } finally {
            sc.close();
        }        
        
    }
}
