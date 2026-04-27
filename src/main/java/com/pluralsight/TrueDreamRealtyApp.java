package com.pluralsight;

import java.io.File;
import java.util.Scanner;

public class TrueDreamRealtyApp {
    public static void main(String[] args) {
        //start the program by showing the home screen
        displayHomeScreen();
        //One scanner for the whole app, take user input
        Scanner scanner = new Scanner(System.in);

    }

    public static void displayHomeScreen() {
        // controls if app keeps running or stops
        //true = keep showing menu
        //false =  exit program
        boolean running = true;

        // loop = keep showing the home screen over and over
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

            //switch is good for menu








        }


    }
}
