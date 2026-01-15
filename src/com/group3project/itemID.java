package com.group3project;

public class itemID {

    private String name;
    private int quantity;
    private double price;


    itemID(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    //method to get name of the item
    public String getName() {
        return name;
    }

    //method to get quantity  of the item
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //method to get price of the item
    public double getPrice() {
        return price;
    }


}
