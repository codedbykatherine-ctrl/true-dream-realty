package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TransactionFileManager {

    private static final String FILE_NAME = "src/main/resources/transactions.csv";

    public static ArrayList<Transaction> loadTransactions() {

        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            // skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                String date = parts[0];
                String time = parts[1];
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);

                Transaction t = new Transaction(date, time, description, vendor, amount);
                transactions.add(t);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file 😭: " + e.getMessage());
        }
        return transactions;
    }

    public static void saveTransaction(Transaction t) {
        // todo: implement method
    }
}
