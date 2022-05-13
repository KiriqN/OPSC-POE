package com.example.opscpoe.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.opscpoe.Collections_page;
import com.example.opscpoe.ItemData;
import com.example.opscpoe.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class CategoryItemsActivity extends AppCompatActivity {

    private ArrayList<ItemData> itemList;

    private Button addBtn;
    private Button backBtn;
    private GridView itemGridView;

    private String categoryName = "";
    public int categoryGoalNumber = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_page);
        // itemList = pull data from bundle

        itemList = new ArrayList();
        try{
            categoryName = getIntent().getStringExtra("name");
            categoryGoalNumber = getIntent().getIntExtra("goal", 0);
            ArrayList itemData = (ArrayList) getIntent().getSerializableExtra("items");

            for(int i = 0; i < itemData.size(); i++) {
                itemList.add((ItemData) itemData.get(i));
                System.out.println("Name: " + itemList.get(i).getItem_name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        backBtn= findViewById(R.id.item_back_button);
        addBtn = findViewById(R.id.add_item_btn);
        itemGridView = findViewById(R.id.item_grid_view);

        ItemGridAdapter gd = new ItemGridAdapter(this, itemList);

        itemGridView.setAdapter(gd);

        itemGridView.setBackgroundColor(Color.WHITE);


        addBtn.setOnClickListener(v -> {
            // Call create item page thing
            // Get newly created item back (with bundles or intents??) with name and image

            int mockImage = getResources().getIdentifier("google.png", "drawable", getPackageName());
            ItemData mockItem = new ItemData("mock name", mockImage);

            itemList.add(mockItem);

            gd.notifyDataSetChanged();
        });

        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Collections_page.class);

            Bundle bundle = new Bundle();

            bundle.putString("name", categoryName);
            bundle.putSerializable("items", itemList);

            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}

class ItemGridAdapter extends BaseAdapter {
    Context c;

    private ArrayList<ItemData> itemList;

    ItemGridAdapter(Context c, ArrayList<ItemData> itemList) {
        this.c = c;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_layout, null);
        }

//        ImageView itemImage = view.findViewById(R.id.item_image_view);
//        itemImage.setImageResource(itemList.get(i).getItem_image());
//        TextView itemName = view.findViewById(R.id.item_title_view);
//        itemName.setText(itemList.get(i).getItem_name());

        return view;
    }
}