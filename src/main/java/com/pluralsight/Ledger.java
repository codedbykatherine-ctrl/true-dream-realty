package com.pluralsight;

import java.util.ArrayList;

public class Ledger {
    public static void displayLedgerScreen() {
        System.out.println(" ledger screen place holder ");
    }

    public void showDeposits(ArrayList<Transaction> transctions) {
        System.out.println("\n ======== DEPOSITS ========");

        for (int i = transaction.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);

            if (t.getAmount() > 0) {
            }
        }

    }
    public void showPayments(ArrayList<Transaction> transaction){
        System.out.println("======== PAYMENTS ========");
        for (int i = transaction.size () -1; i>= 0; i--){
            Transaction t = transactions.get(i);

            //< 0 negative money taken out to make a payment
            // only shows payment transaction
            if (t.getamount() < 0) {
                System.out.println(t);
            }
        }
    }


//start at the last item of the list -1 line starts at 0
// i>= keep going to until first item
// i-- go backwords count down