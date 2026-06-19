import java.util.Scanner;

class ATM {

    private String userName;
    private int pin;
    private double balance = 1000;

    public ATM(String userName, int pin) {
        this.userName = userName;
        this.pin = pin;
    }

    public boolean login(int enteredPin) {
        return enteredPin == pin;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " Deposited Successfully!");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " Withdrawn Successfully!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void changePin(int oldPin, int newPin) {

        if (oldPin == pin) {

            if (newPin >= 1000 && newPin <= 9999) {
                pin = newPin;
                System.out.println("PIN Changed Successfully!");
            } else {
                System.out.println("PIN must be 4 digits!");
            }

        } else {
            System.out.println("Wrong Old PIN!");
        }
    }

    public void welcomeUser() {
        System.out.println("Welcome " + userName);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CREATE ACCOUNT =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        int pin;

        while (true) {

            System.out.print("Create 4-Digit PIN: ");
            pin = sc.nextInt();

            if (pin >= 1000 && pin <= 9999) {
                break;
            }

            System.out.println("Invalid PIN!");
        }

        ATM atm = new ATM(name, pin);

        System.out.println("\nAccount Created Successfully!");

        System.out.print("Enter PIN to Login: ");
        int enteredPin = sc.nextInt();

        if (!atm.login(enteredPin)) {
            System.out.println("Invalid PIN!");
            return;
        }

        atm.welcomeUser();

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Amount: ");
                    atm.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    atm.withdraw(sc.nextDouble());
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:

                    System.out.print("Enter Old PIN: ");
                    int oldPin = sc.nextInt();

                    System.out.print("Enter New PIN: ");
                    int newPin = sc.nextInt();

                    atm.changePin(oldPin, newPin);
                    break;

                case 5:
                    System.out.println("Thank You For Using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}