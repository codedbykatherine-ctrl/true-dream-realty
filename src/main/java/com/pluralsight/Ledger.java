package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    //ledger has it's own menu
    static Scanner scanner = new Scanner(System.in);

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
    public static void showAllTransactions(ArrayList<Transaction> transactions){
        System.out.println("\n======== ALL TRANSACTIONS ========");

        for ( int i = transactions.size()-1;i >= 0;i-- ){
            Transaction t = transactions.get(i);
            System.out.println(t);
            }
        }


    // D) Deposits
    public static void showDeposits(ArrayList<Transaction> transactions) {
        System.out.println("\n ======== DEPOSITS ========");

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);

            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }

    }
    // P) Payments
    public static void showPayments(ArrayList<Transaction> transactions) {
        System.out.println("======== PAYMENTS ========");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);

            //< 0 negative money taken out to make a payment
            // only shows payment transaction
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }
}


//start at the last item of the list -1 line starts at 0
// i>= keep going to until first item
// i-- go backwords count down