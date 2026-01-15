package com.group3project;


//User must hava an array list to keep track of items selected

//so why are we inheriting from itemId cant we just initiate a itemID class in the userID calss then move on >>


import java.util.ArrayList;

public class userID {
    private String name;
    private ArrayList<itemID> itemSelected;

    public userID(String name) {
        this.name = name;
        this.itemSelected = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<itemID> getItemSelected() {
        return this.itemSelected;
    }

    public void addItem(itemID item, int quantity) {
        itemID itemCopy = new itemID(item.getName(), quantity, item.getPrice());
        this.itemSelected.add(itemCopy);
    }


}
