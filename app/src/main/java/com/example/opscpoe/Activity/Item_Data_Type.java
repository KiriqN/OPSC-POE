package com.example.opscpoe.Activity;

import android.net.Uri;

public class Item_Data_Type {


    Uri item_image;

    String item_name;

    int item_price;

    Category_Data_Type host_collection_category;

    int item_id;


    public Item_Data_Type(Uri item_image, String item_name, int item_price, Category_Data_Type host_collection_category, int item_id) {
        this.item_image = item_image;
        this.item_name = item_name;
        this.item_price = item_price;
        this.host_collection_category = host_collection_category;
        this.item_id = item_id;
    }

    public Uri getItem_image() {
        return item_image;
    }

    public void setItem_image(Uri item_image) {
        this.item_image = item_image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public Category_Data_Type getHost_collection_category() {
        return host_collection_category;
    }

    public void setHost_collection_category(Category_Data_Type host_collection_category) {
        this.host_collection_category = host_collection_category;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
