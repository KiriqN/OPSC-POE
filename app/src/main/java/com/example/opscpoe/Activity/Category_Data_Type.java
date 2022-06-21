package com.example.opscpoe.Activity;

import java.lang.reflect.Array;
import java.util.List;

public class Category_Data_Type {



    String category_name;

    int max_items;

    int current_items;

    int remaining_items;

    List<Item_Data_Type> items;


    public Category_Data_Type(String category_name, int max_items, int current_items, int remaining_items, List<Item_Data_Type> items) {
        this.category_name = category_name;
        this.max_items = max_items;
        this.current_items = current_items;
        this.remaining_items = remaining_items;
        this.items = items;
    }


    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getMax_items() {
        return max_items;
    }

    public void setMax_items(int max_items) {
        this.max_items = max_items;
    }

    public int getCurrent_items() {
        return current_items;
    }

    public void setCurrent_items(int current_items) {
        this.current_items = current_items;
    }

    public int getRemaining_items() {
        return remaining_items;
    }

    public void setRemaining_items(int remaining_items) {
        this.remaining_items = remaining_items;
    }

    public  List<Item_Data_Type> getItems() {
        return items;
    }

    public void setItems( List<Item_Data_Type> items) {
        this.items = items;
    }
}
