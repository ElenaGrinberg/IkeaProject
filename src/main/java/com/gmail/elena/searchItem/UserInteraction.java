package com.gmail.elena.searchItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class UserInteraction {

    public static final Logger log = LogManager.getLogger(UserInteraction.class);


    public static int inputManualOrAutomaticChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("1. Input data manually. 2. Use the saved data from a file.");
        while (choice == 0) {
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (Exception err) {
                log.info(err);
            }
            if (choice != 1 && choice != 2) {
                System.out.println("Your choice is not correct. Enter the number 1 or 2");

                choice = 0;
            }
        }
        return choice;
    }

    public static String inputCounty() {
        System.out.println("Where are you from? Input your country");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String inputCatalogNumber() {
        System.out.println("Input the catalog number of item");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String inputCity(List<String> cities) {
        System.out.println("There are IKEA in cities");
        for (String city : cities) {
            System.out.println(city);
        }
        System.out.println("Input your city");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void printProductNotFoundMessage(Item myItem) {
        System.out.println("The product " + myItem.getProduct() + " not found");
    }

    public static void printMultipleProductMessage(Item myItem) {
        System.out.println("There are too much " + myItem.getProduct() + "'s in IKEA. Try searching the item by Number");
    }

    public static void printProductAmountMessage(Item myItem) {
        if (!myItem.getAmount().equals("0")) {
            System.out.println("There are  " + myItem.getAmount() + " items");
        } else {
            System.out.println("This store does not have this item");
        }
    }

    public static void printPrice(Item myItem) {
        System.out.println("Item price is " + myItem.getPrice());
    }

    public static void printErrorReadingFromFileMessage() {
        System.out.println("forSearching.text is not readable");
    }
}
