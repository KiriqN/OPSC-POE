package com.example.opscpoe;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageButton;

import java.io.Serializable;
import java.net.URI;

public class ItemData implements Serializable {
    public String item_name;
    public int item_image;

    public ItemData (String give_item_name, int give_item_image) {
        item_name = give_item_name;
        item_image = give_item_image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}
