package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

//I made the Scanner static because all of my methods are static, and static methods can only directly access static variables.
// By making the Scanner static, I can reuse the same input object across the entire application without needing to create multiple instances.

public class TrueDreamRealtyApp {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions = new ArrayList<>();


    //this scanner belongs to the CLASS, not to a specific object
    //One scanner for the whole app, take user input
    //this method does something but returns nothing
    public static void main(String[] args) {
        //start the program by showing the home screen
        transactions = TransactionFileManager.loadTransactions();
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

            if(userChoice.isBlank()) {
                continue;
            }

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
                    // if user types something random
                    System.out.println("Invalid option. Please choose D, P, L, or X ");
                    break;
            }
            //I created separate methods for each menu option so that each feature is modular and easier to manage. Right now they are placeholders,
            // but they will later contain the logic for adding deposits, processing payments, and displaying the ledger.
        }
    }


    public static void addDeposit() {
        System.out.println("\n-------- 💰 ADD DEPOSIT 💰--------");

        System.out.println("When did this deposit happen? (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.println(" What time did it occur? (e.g. 8:10 or 08:10:00): ");
        String timeInput = scanner.nextLine().trim();


        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm[:ss]");
        LocalTime time;

        try{
            time = LocalTime.parse(timeInput, timeFormatter);
        } catch (Exception e){
            System.out.println("Invalid time try like 8:10 or 08:10:03");
            return;
        }

        System.out.print("What is this deposit for? ");
        String description = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("How much is the deposit? ");
        String input = scanner.nextLine().replace(",", "");
        double amount;

        try {
            amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("we can't buy a house with that input" +
                    " 😭 enter a number like 6,000 or 6000.00.");
            return;
        }
          //absolute value turns any number to positive
        amount = Math.abs(amount);
        Transaction t = new Transaction (date,time, description, vendor, amount);


        transactions.add(t);
        TransactionFileManager.saveTransaction(t);


        System.out.println("\\n✨ Deposit recorded successfully!\" ");
        Ledger.printTransaction(t);
        // this helps pause the program until user enters then program continues
        System.out.println("\nPress ENTER to return to the home screen .....");
        scanner.nextLine();
        //method ends after user press enter then loops back to home screen

    }

    public static void makePayment() {
        System.out.println("\n -------- 💸 MAKE PAYMENT 💸 --------");


        //strict format now
        //TODO MAKE FLEXIBLE FORMAT FOR DATE
        System.out.println(" When did this payment happen? (YYYY-MM-DD):   ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        //time is flexible with input
        System.out.println(" What time did it occur? (e.g. 8:10 or 08:10:00): ");
       String timeInput = scanner.nextLine().trim();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm[:ss]");
        LocalTime time;
        try{
            time = LocalTime.parse(timeInput, timeFormatter);
        } catch (Exception e){
            System.out.println("Invalid time try like 8:10 or 08:10:03");
            return;
        }


        System.out.print("Enter description : ");
        String description = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter amount: ");
        String input = scanner.nextLine().replace(",", "");
        double amount;

        try {
            amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("you just tried to pay with nonsense 😭 " +
                    "enter a NUMBER like 6000.");
            return;
        }

        // - making sure it is negative
        amount = -Math.abs(amount);
        Transaction t = new Transaction(date, time, description, vendor, amount);


        transactions.add(t);
        TransactionFileManager.saveTransaction(t);
        System.out.println("\\n✨ PAYMENT recorded successfully!\"");
        Ledger.printTransaction(t);

        // this helps pause the program until user enters then program continues
        System.out.println("\nPress ENTER to return to the home screen .....");
        scanner.nextLine();
        //method ends after user press enter then loops back to home screen

    }
}

//H ONE OR TWO DIGIT HH TWO
// :  expect 8:10 EX
// MIN ALWAYS TWO
// [] THIS MEANS OPTIONAL