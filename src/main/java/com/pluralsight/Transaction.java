package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Transaction {//date |time |description |vendor| amount

    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;


    // constructor = the method that builds one transaction object
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    } // these match the csv columns:

    //getters let other files read the private values safely

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
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
    // i am replacing default tostring()
    @Override
    public String toString() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // method returns to a string
        return date + "|" +
                //build csv line
                time.format(timeFormatter) + "|"
                + description + "|"
                + vendor + "|" +
                String.format("%.2f", amount);
        // amount = 1850
    }
}
