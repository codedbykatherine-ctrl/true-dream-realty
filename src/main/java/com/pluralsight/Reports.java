package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
//what happened this month?
//what happened last month?
//what happened this year?
//what happened last year?


//localdate is like having a calendar app
// month year reports
public class Reports {
     static Scanner scanner = new Scanner(System.in);

    public static void displayReportsScreen(ArrayList<Transaction> transactions) {
        boolean running = true;

        while (running) {
            System.out.println("======== 📊 REPORTS 📊 ========");
            System.out.println("1) 📅 Month To Date");
            System.out.println("2) ⏮️ Previous Month");
            System.out.println("3) 🗓️ Year to Date");
            System.out.println("4) ↞ Previous Year");
            System.out.println("5) 🔍Search by Vendor");
            System.out.println("6) 📝 Custom Search");
            System.out.println("0) 🔙 Back");
            System.out.println("Choose an option: ");

            String choice = scanner.nextLine().trim();

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
                case "6":
                    customSearch(transactions);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose 1, 2, 3, 4, 5, or 0. [😬");
            }
        }
    }
    //for loops go through every transaction in the list

    public static void monthToDate(ArrayList<Transaction> transactions) {
        System.out.println("\n======== 📅 MONTH TO DATE 📅 ========");
        LocalDate today = LocalDate.now();

        //current month + current day + current year
        for (Transaction t : transactions) {
            LocalDate transactionDate = t.getDate();

            if (transactionDate.getMonth() == today.getMonth()
                    //same month
                    && transactionDate.getYear() == today.getYear()
                    //same year
                    && !transactionDate.isAfter(today)) {
                // do not show anything after today
                Ledger.printTransaction(t);

            }
        }

    }

    public static void previousMonth(ArrayList<Transaction> transactions) {
        System.out.println("\n======== ⏮️ Previous Month ⏮️========");

        LocalDate previousMonthDate = LocalDate.now().minusMonths(1);

        for (Transaction t : transactions) {
            LocalDate transactionDate = t.getDate();
            //today's date
            //subtract 1 month from today and match ,month + year
            if (transactionDate.getMonth() == previousMonthDate.getMonth()
                    && transactionDate.getYear() == previousMonthDate.getYear()) {
                Ledger.printTransaction(t);
            }

        }

    }

    public static void yearToDate(ArrayList<Transaction> transactions) {
        System.out.println("\n======== 🗓️ Year to Date 🗓️========");
        LocalDate today = LocalDate.now();

        for (Transaction t : transactions) {
            LocalDate transactionDate = t.getDate();
            if (transactionDate.getYear() == today.getYear()
                    //same year
                    && !transactionDate.isAfter(today)) {
                //not after today
                Ledger.printTransaction(t);
            }
        }

    }

    public static void previousYear(ArrayList<Transaction> transactions) {
        System.out.println("\n======== ↞ Previous Year ↞ ========");
        int previousYear = LocalDate.now().getYear() - 1;
        //today's date to calculate reports
        for (Transaction t : transactions) {
            LocalDate transactionDate = t.getDate();
            //current year minus -  1
            if (transactionDate.getYear() == previousYear) {
                Ledger.printTransaction(t);

            }
        }
    }

    public static void searchByVendor(ArrayList<Transaction> transactions) {
        System.out.println("\n======== 🔍Search by Vendor 🔍========");
        System.out.println("Enter vendor name: ");

        Scanner scanner = new Scanner(System.in);
        String searchVendor = scanner.nextLine().trim().toLowerCase();

        System.out.println("\n======== 🔍Search RESULTS 🔍========");

        for (Transaction t : transactions) {
            if (t.getVendor().toLowerCase().contains(searchVendor)) {
                //contains allow partial match intead of exact match
                Ledger.printTransaction(t);
            }

        }
    }

    public static void customSearch(ArrayList<Transaction> transactions) {
        System.out.println("\n======== 📝 Custom Search 📝 ========");

        System.out.println("Start date (YYYY-MM-DD) or press Enter to skip: ");
        String startInput = scanner.nextLine().trim();

        System.out.println("End date (YYYY-MM-DD) or press Enter to skip: ");
        String endInput = scanner.nextLine().trim();

        System.out.println("Description or press Enter to skip: ");
        String descriptionInput = scanner.nextLine().trim().toLowerCase();

        System.out.println("Vendor or press Enter to skip: ");
        String vendorInput = scanner.nextLine().trim().toLowerCase();

        System.out.println("Amount or press Enter to skip: ");
        String amountInput = scanner.nextLine().replace(",", "").trim();

        LocalDate startDate = null;
        LocalDate endDate = null;
        Double amount = null;

        try {
            if (!startInput.isBlank()) {
                startDate = LocalDate.parse(startInput);
            }
            if (!endInput.isBlank()) {
                endDate = LocalDate.parse(endInput);
            }
            if (!amountInput.isBlank()) {
                amount = Double.parseDouble(amountInput);
            }
        } catch (Exception e) {
            System.out.println("Invalid search input 😬 check your date or amount format!");
            return;
        }
        System.out.println("\n======== 📝 Custom Search 📝 ========");
        boolean found = false;

        for (Transaction t : transactions) {
            boolean matches = true;

            if (startDate != null && t.getDate().isBefore(startDate)) {
                matches = false;
            }
            if (endDate != null && t.getDate().isAfter(endDate)) {
                matches = false;
            }
            if (!descriptionInput.isBlank()
                    && !t.getDescription().toLowerCase().contains(descriptionInput)) {
                matches = false;
            }
            if (!vendorInput.isBlank()
                    && !t.getVendor().toLowerCase().contains(vendorInput)) {
                matches = false;
            }
            if (amount != null && t.getAmount() != amount) {
                matches = false;
            }
            if (matches) {
                Ledger.printTransaction(t);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching transactions found.🥸");
        }
    }
}




