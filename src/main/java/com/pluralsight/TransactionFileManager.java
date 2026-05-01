package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;


public class TransactionFileManager {

    private static final String FILE_NAME = "src/main/resources/transactions.csv";

    public static ArrayList<Transaction> loadTransactions() {

        ArrayList<Transaction> transactions = new ArrayList<>();

        //try (...) anything parentheses = "resource"
        // java will help - auto clean it up
        //FileReader - opens file
        //BufferedReader - lets u read line (faster + easier)
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);

                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);

                Transaction t = new Transaction(date, time, description, vendor, amount);
                transactions.add(t);
            }
        } catch (Exception e) {
            System.out.println("Error Reading File 😭: " + e.getMessage());
        }

        return transactions;
    }
     public static void saveTransaction (Transaction t ){
         try (FileWriter writer = new FileWriter((FILE_NAME), true)) {
            writer.write(System.lineSeparator() + t.toString());
        } catch(Exception e ){
            System.out.println("Error Saving File 😭: " + e.getMessage());
        }
      }

      }
