package com.mainapp;



import java.util.Scanner;
import java.util.ArrayList;

public class ATMSimulation {
    // User class to represent a bank account
    static class User {
        private String pin;
        private double balance;
        private ArrayList<String> transactionHistory;

        // Constructor to initialize user data
        public User(String pin, double initialBalance) {
            this.pin = pin;
            this.balance = initialBalance;
            this.transactionHistory = new ArrayList<>();
            addTransaction("Account created with balance: $" + initialBalance);
        }

        // Get current balance
        public double getBalance() {
            return balance;
        }

        // Set new PIN
        public void setPin(String newPin) {
            this.pin = newPin;
            addTransaction("PIN changed.");
        }

        // Add deposit to account
        public void deposit(double amount) {
            balance += amount;
            addTransaction("Deposited: $" + amount);
        }

        // Withdraw from account
        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                addTransaction("Withdrew: $" + amount);
                return true;
            } else {
                System.out.println("Insufficient funds.");
                return false;
            }
        }

        // Add transaction to history
        private void addTransaction(String transaction) {
            transactionHistory.add(transaction);
        }

        // View transaction history
        public void showTransactionHistory() {
            System.out.println("Transaction History:");
            if (transactionHistory.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                for (String transaction : transactionHistory) {
                    System.out.println(transaction);
                }
            }
        }

        // Validate PIN
        public boolean validatePin(String inputPin) {
            return pin.equals(inputPin);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = new User("1234", 1000.0); // Initialize with a default PIN and balance

        System.out.println("Welcome to the ATM Machine!");

        // PIN Authentication
        int attempts = 0;
        boolean authenticated = false;
        while (attempts < 3) {
            System.out.print("Please enter your PIN: ");
            String enteredPin = scanner.nextLine();
            if (currentUser.validatePin(enteredPin)) {
                authenticated = true;
                break;
            } else {
                System.out.println("Incorrect PIN. Try again.");
                attempts++;
            }
        }

        if (!authenticated) {
            System.out.println("Too many incorrect attempts. Exiting...");
            scanner.close();
            return;
        }

        // ATM Operations Menu
        int option;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Please select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Account balance inquiry
                    System.out.println("Your current balance is: $" + currentUser.getBalance());
                    break;

                case 2:
                    // Cash deposit
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (depositAmount > 0) {
                        currentUser.deposit(depositAmount);
                        System.out.println("Deposited: $" + depositAmount);
                    } else {
                        System.out.println("Deposit amount must be greater than zero.");
                    }
                    break;

                case 3:
                    // Cash withdrawal
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (withdrawalAmount > 0) {
                        boolean success = currentUser.withdraw(withdrawalAmount);
                        if (success) {
                            System.out.println("Withdrew: $" + withdrawalAmount);
                        }
                    } else {
                        System.out.println("Withdrawal amount must be greater than zero.");
                    }
                    break;

                case 4:
                    // PIN change
                    System.out.print("Enter your new PIN: ");
                    String newPin = scanner.nextLine();
                    currentUser.setPin(newPin);
                    System.out.println("Your PIN has been changed successfully.");
                    break;

                case 5:
                    // View transaction history
                    currentUser.showTransactionHistory();
                    break;

                case 6:
                    // Exit the ATM system
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 6);

        scanner.close();
    }
}