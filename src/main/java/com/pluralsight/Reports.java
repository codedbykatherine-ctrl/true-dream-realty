package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.TrueDreamRealtyApp.scanner;

//what happened this month?
//what happened last month?
//what happened this year?
//what happened last year?


//localdate is like having a calendar app
// month year reports
public class Reports {
    public static void displayReportsScreen(ArrayList<Transaction> transactions) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("======== 📊 REPORTS 📊 ========");
            System.out.println("1) 📅 Month To Date");
            System.out.println("2) ⏮️ Previous Month");
            System.out.println("3) 🗓️ Year to Date");
            System.out.println("4) ↞ Previous Year");
            System.out.println("5) 🔍Search by Vendor");
            System.out.println("0) 🔙 Back");
            System.out.println("Choose an option: ");

            String choice = scanner.newLine().trim();

            switch (choice) {
                case "1":
                    monthToDate(transactions);
                    break;
                case "2":
                    previousMonth(transactions);
                    break;
                case "3":
                    yearToDate(transactions);
                    break;
                case "4":
                    previousYear(transactions);
                    break;
                case "5":
                    searchByVendor(transactions);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose 1, 2, 3, 4, 5, or 0.");
            }
        }
    }

    public static void monthToDate(ArrayList<Transaction>transactions){
        System.out.println("\n======== 📅 MONTH TO DATE 📅 ========");
         LocalDate today = LocalDate.now();

          //current month + current day + current year
         for (Transaction t : transactions) {
             LocalDate transactionDate = t.getDate();

             if (transactionDate.t.getMonth() == today.getMonth()
                     //same month
                 && transactionDate.getYear() == today.getYear()
                     //same year
                 && !transactionDate.isAfter(today)) {
                     // do not show anything after today
                     Ledger.printTransaction(t);

             }
         }

    }
    public static void previousMonth(ArrayList<Transaction>transactions){
        System.out.println("======== ⏮️ Previous Month ⏮️========");

        LocalDate previousMonthDate = LocalDate.now().minusMonth(1);

        for (Transaction t : transactions){
            LocalDate transactionDate = t.getDate();
            if (transactionDate.getMonth() == previousMonthDate.getMonth()
                && transactionDate.getYear() == previousMonthDate.getYear()) {
                Ledger.printTransaction(t);
            }

        }

    }
    public static void yearToDate(ArrayList<Transaction>transactions){
        System.out.println("======== 🗓️ Year to Date 🗓️========");
        LocalDate yearToDate = LocalDate.now();

        for (Transaction t : transactions){
            LocalDate transactionDate = t.getDate();
            if (transactionDate.getYear() == today.getYear()
                %% !transcationDate.isAfter(today)) {
                Ledger.printTransaction(t);
            }
        }

    }
    public static void previousYear(ArrayList<Transaction>transactions){
        System.out.println("======== ↞ Previous Year ↞ ========");


        for (Transaction t : transactions){
            LocalDate transactionDate = t.getDate();
            if (transactionDate.getYear() == previousYear){
                Ledger.printTransaction(t);

            }
        }
    }
    public static void searchByVendor(ArrayList<Transaction>transactions){
        System.out.println("======== 🔍Search by Vendor 🔍========";
        String searchVendor = scanner.newLine().trim().toLowerCase();

        System.out.println("======== 🔍Search RESULTS 🔍========");

        for ((Transaction t : transactions)) {
            if(t.getVendor().to.LowerCase().contains(searchVendor)){
                Ledger.printTransaction(t);
            }

        }


    }
}


