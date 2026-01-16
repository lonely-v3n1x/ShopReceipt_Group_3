package com.group3project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class shop {

    static final double TAX = 0.085; // 68.5%

    static userID userSelection;

    static ArrayList<itemID> inventory = new ArrayList<>();

    static {
        inventory.add(new itemID("Apple", 50, 0.99));
        inventory.add(new itemID("Banana", 30, 0.59));
        inventory.add(new itemID("Milk", 20, 2.49));
        inventory.add(new itemID("Bread", 15, 1.99));
        inventory.add(new itemID("Chocolate", 100, 1.50));
    }

    public static void displayMenu() {
        System.out.println("Here Are the Items available in the shop:");
        System.out.printf("%5s%-15s%s\n", "", "ITEMS", "PRICE");
        System.out.println("_".repeat(55));
        for (int i = 0; i < inventory.size(); i++) {
//            System.out.println((i+1)+ " ".repeat(5)+inventory.get(i));
            System.out.printf("%-5d%-15s%s\n", (i + 1), inventory.get(i).getName(), inventory.get(i).getPrice());
        }

        System.out.println("Enter the number associated to the item you want to purchase to add it your list");
        System.out.println("Enter 1 to add " + inventory.getFirst().getName() + " to your list");
        System.out.println("Enter any letter to exit item selection");
    }

    public static void handleShopping() {

        // To be implemented: Handle user shopping process
        Scanner sc = new Scanner(System.in);


        System.out.print("Your name: ");
        String userName = sc.nextLine();
        userSelection = new userID(userName);

        while (true) {


//            System.out.print("Please enter your choice: ");
            System.out.print("\nPlease enter item number (or letter to finish): ");
            try {
                int userChoice = sc.nextInt();

                if (userChoice < 1 || userChoice > inventory.size()) {
                    System.out.println("Please enter a valid choice....");
                    continue;
                }

                itemID selectedItem = inventory.get(userChoice - 1);

                System.out.print("How many " + selectedItem.getName() + " do you want? ");
                int qty = sc.nextInt();

                userSelection.addItem(selectedItem, qty);
                System.out.println("Added " + qty + " " + selectedItem.getName() + "(s) to cart.");


            } catch (InputMismatchException ex) {
                break;
            }
        }
    }


    static void main() {
        System.out.println(Logo.getLogo());
//        System.out.println(" ".repeat(20)+"Welcome to my shop.");
        System.out.printf("%40s%s\n\n", "", "Welcome to the 7-Eleven shop.");

        displayMenu();

        handleShopping();

        for (int i = 0; i < userSelection.getItemSelected().size(); i++) {
            System.out.println(userSelection.getItemSelected().get(i).getQuantity() + "x " + userSelection.getItemSelected().get(i).getName());
        }

        Receipt.displayReceipt(userSelection.getItemSelected(), userSelection, TAX);
        Receipt.saveToFile(userSelection.getItemSelected(), userSelection, TAX);


    }
}
