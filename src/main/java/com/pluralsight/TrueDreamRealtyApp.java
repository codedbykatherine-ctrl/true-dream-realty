package com.pluralsight;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
//I made the Scanner static because all of my methods are static, and static methods can only directly access static variables.
// By making the Scanner static, I can reuse the same input object across the entire application without needing to create multiple instances.

public class TrueDreamRealtyApp {
    static Scanner scanner = new Scanner(System.in);

    //this scanner belongs to the CLASS, not to a specific object
    //One scanner for the whole app, take user input
    //this method does something but returns nothing
    public static void main(String[] args) {
        //start the program by showing the home screen
        displayHomeScreen();
    }

    public static void displayHomeScreen() {
        // controls if app keeps running or stops
        //true = keep showing menu
        //false =  exit program
        boolean running = true;


        // loop = keep showing the home screen over and over
        //keep bringing the user back to the home screen
        while (running) {
            System.out.println("===================================");
            System.out.println("          TRUE DREAM REALTY        ");
            System.out.println("===================================");
            System.out.println("D) Add deposit");
            System.out.println("P) Make a Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println(" Choose an option: ");

            // get what the user types
            //trim. removes spaces " d  "
            // touppercase d becomes D
            String userChoice = scanner.nextLine().trim().toUpperCase();

            //switch is good for menu
            switch (userChoice) {
                case "D":
                    //if they pick D - go to deposit
                    addDeposit();
                    break; // stop here do not fall into other cases
                case "P":
                    // if they picked p - go to payment method
                    makePayment();
                    break;
                case "L":
                    // if they picked L - go to ledger screen
                    Ledger.displayLedgerScreen();
                    break;
                case "X":
                    //if they picked x - exit
                    System.out.println("Goodbye " +
                            "Affirmation of the Day " +
                            " I am open to receiving wealth in all forms ");
                    // stops the loop - app ends
                    running = false;
                    break;

                default:
                    // if user tpes something random
                    System.out.println("Invalid option. Please choose D, P, L, or X ");
                    break;
            }
            //I created separate methods for each menu option so that each feature is modular and easier to manage. Right now they are placeholders,
            // but they will later contain the logic for adding deposits, processing payments, and displaying the ledger.
        }
    }

    public static void displayHomeScreen() {
        // controls if app keeps running or stops
        //true = keep showing menu
        //false =  exit program
        boolean running = true;


        // loop = keep showing the home screen over and over
        //keep bringing the user back to the home screen
        while (running) {
            System.out.println("===================================");
            System.out.println("          TRUE DREAM REALTY        ");
            System.out.println("===================================");
            System.out.println("D) Add deposit");
            System.out.println("P) Make a Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println(" Choose an option: ");

            // get what the user types
            //trim. removes spaces " d  "
            // touppercase d becomes D
            String userChoice = scanner.nextLine().trim().toUpperCase();

            //switch is good for menu
            switch (userChoice) {
                case "D":
                    //if they pick D - go to deposit
                    addDeposit();
                    break; // stop here do not fall into other cases
                case "P":
                    // if they picked p - go to payment method
                    makePayment();
                    break;
                case "L":
                    // if they picked L - go to ledger screen
                    Ledger.displayLedgerScreen();
                    break;
                case "X":
                    //if they picked x - exit
                    System.out.println("Goodbye " +
                            "Affirmation of the Day " +
                            " I am open to receiving wealth in all forms ");
                    // stops the loop - app ends
                    running = false;
                    break;

                default:
                    // if user tpes something random
                    System.out.println("Invalid option. Please choose D, P, L, or X ");
                    break;
            }
            //I created separate methods for each menu option so that each feature is modular and easier to manage. Right now they are placeholders,
            // but they will later contain the logic for adding deposits, processing payments, and displaying the ledger.
        }
    }

    public static void addDeposit() {
        System.out.println("\n-------- ADD DEPOSIT --------");

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.println("Deposit Recorded: ");
        System.out.println(description + "|" + vendor + "| $ " + amount);
    }

    public static void makePayment() {
        System.out.println("\n -------- MAKE PAYMENT --------");
        System.out.print("Enter description : ");
        String description = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Deposit Recorded: ");
        System.out.println(description + "|" + vendor + "| $ " + amount);
    }
}