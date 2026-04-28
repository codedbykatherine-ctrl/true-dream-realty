package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Transaction {//date |time |description |vendor| amount
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    // constructor = the method that builds one transaction object
    public Transaction(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    } // these match the csv columns:

    // this creates a transaction using today's date and current time
    public static Transaction now(String description, String vendor, double amount) {
        String date = LocalDate.now().toString();
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return new Transaction(date, time, description, vendor, amount);
    }

    //getters let other files read the private values safely
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;

    }

    //this decides how a transaction prints on the screen
    //this method is intentionally replacing the default behavior
    @Override
    public String toString() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + String.format("%.2f", amount);

    }
}
