package com.group3project;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Receipt {

    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now();

    public static void displayReceipt(ArrayList<itemID> items, userID customer, double tax) {

        //clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();


        System.out.println(Logo.getLogo());

        System.out.printf("%53s%s\n", "", "STORE #12345");
        System.out.printf("%45s%s\n", "", "123 MAIN ST, CITYVILLE, CA 90001");
        System.out.printf("%48s%s\n", "", "TEL: (233) 244079765");

        //display Date
        System.out.println(" ".repeat(5) + "DATE: " + date);
        //display Time
        System.out.println(" ".repeat(5) + "TIME: " + time);

        //display Customer Name
        System.out.println(" ".repeat(5) + "CUSTOMER NAME: " + customer.getName());

        // qty item        price
        System.out.printf("%5s%-10s%-75s%s\n", "", "QTY", "ITEM", "PRICE");
        System.out.println(" ".repeat(5) + "_".repeat(90));


        //loop and display items here
        for (itemID item : items) {
            System.out.printf("%5s%-10d%-75s%s\n", "", item.getQuantity(), item.getName(), item.getPrice());
        }

        System.out.println(" ".repeat(5) + "_".repeat(90));

        //taxes and calculations
        System.out.printf("%5s%-10s%-75f\n", "", "SUBTOTAL ", customer.getSubTotal());
        System.out.printf("%5s%-10s%s%s%-75f\n", "", "TAXES( ", String.valueOf(tax), ")", customer.getSubTotal());
        System.out.printf("%5s%-10s%-75f\n", "", "TOTAL ", customer.getTotal(tax));

        //footer
        System.out.printf("%53s%s\n", "", "ORDER ID: #711-PROJ-025JK");
        System.out.printf("%45s%s\n", "", "TELL US HOW WE DID AT");
        System.out.printf("%48s%s\n", "", "7-ELEVEN.COM");


    }

    ;

    static void main() {
//       displayReceiptj();

    }

    ;
}
