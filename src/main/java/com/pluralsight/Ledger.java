package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class Ledger {
    //ledger has it's own menu
    static Scanner scanner = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void printTransaction(Transaction t ){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        // user can get fancy and use $
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String color = (t.getAmount() >= 0) ? GREEN : RED;

        System.out.println(color + "════════════════════════════");
        System.out.println("DATE:" + t.getDate());
        System.out.println("DESC:"+ t.getDescription());
        System.out.println("VENDOR:"+ t.getVendor());
        System.out.println("AMOUNT:" + currency.format((t.getAmount())));
        System.out.println("════════════════════════════" );
        System.out.print(RESET);
    }


    public static void displayLedgerScreen() {
        boolean running = true;
        while (running){
            ArrayList<Transaction>transactions = TransactionFileManager.loadTransactions();

            System.out.println("\n======== LEDGER ========");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().toUpperCase();

            switch(choice){
                case "A":
                    showAllTransactions(transactions);
                    break;
                case "D":
                    showDeposits(transactions);
                    break;
                case "P":
                    showPayments(transactions);
                    break;
                case "R":
                    Reports.displayReportsScreen(transactions);
                    break;
                case "H":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose A, D, P, R, or H.");

            }

        }

    }
     // A) ALL
    public static void showAllTransactions(ArrayList<Transaction> transactions) {
        System.out.println("\n======== ✨ALL TRANSACTIONS ✨ ========");

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            printTransaction(t);
            }
        }


    // D) Deposits
    public static void showDeposits(ArrayList<Transaction> transactions) {
        System.out.println("\n ======== 💰DEPOSITS 💰========");
                                        //last ,keep going , backwards
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);

            if (t.getAmount() > 0) {
                //only money going in
               printTransaction(t);
               Ledger.printTransaction(t);
                System.out.print(Ledger.RESET);
                System.out.println("\n Press ENTER to return to Home Screen....");
                scanner.nextLine();
            }
        }

    }
    // P) Payments
    public static void showPayments(ArrayList<Transaction> transactions) {
        System.out.println("======== 💸 PAYMENTS 💸========");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);

            //< 0 negative money taken out to make a payment
            // only shows payment transaction
            if (t.getAmount() < 0) {
                printTransaction(t);
                //money out
            }
        }
        System.out.println("\n Press ENTER to return to Ledger...");
        scanner.nextLine();
    }
}


//start at the last item of the list -1 line starts at 0
// i>= keep going to until first item
// i-- go backwords count down