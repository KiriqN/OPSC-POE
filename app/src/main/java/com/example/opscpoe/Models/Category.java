package com.example.opscpoe.Models;

import com.example.opscpoe.ItemData;

import java.util.ArrayList;
import java.util.LinkedList;

public class Category {

    private ArrayList<ItemData> itemList = new ArrayList();

    private int goal = 0;

    private String name;

    public Category(String name, int goal) {
        this.goal= goal;
        this.name = name;
    }

    public void addItem(ItemData item) {
        itemList.add(item);
    }

    public ArrayList<ItemData> getItems() {
        return itemList;
    }

    public void updateItems(ArrayList<ItemData> itemList) {
        this.itemList = itemList;
    }

    public int getGoalNumber() {
        return goal;
    }

    public String getName() {
        return name;
    }


}
