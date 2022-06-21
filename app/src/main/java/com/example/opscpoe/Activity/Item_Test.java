package com.example.opscpoe.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.opscpoe.R;
import com.google.android.material.button.MaterialButton;

import java.util.Map;

public class Item_Test extends AppCompatActivity implements recycler_view_interface {

    String[] data = {""};
    int counter = 0;


    //ArrayList<Category_Data_Type> category_data_types = new ArrayList<>();

    public static final String TAG = "yay I'm clicked";

    int category_index;

    Button add_item_button;

    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_test);

        category_index = getIntent().getIntExtra("category_index_data", 0);

        Toast.makeText(this, String.valueOf(category_index), Toast.LENGTH_SHORT).show();


        add_item_button = findViewById(R.id.add_item_button);
        back_button = findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Back_Button();
            }
        });

        //category_data_types = UserCategories.user_category_information;

        List<String> items = new LinkedList<>();
        // items.add("My Category 1");


        RecyclerView recyclerView = findViewById(R.id.items_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(items, this);
        recyclerView.setAdapter(adapter);

        //Button btn = findViewById(R.id.Add);

        //EditText editText = (EditText) findViewById(R.id.et_item);





        AddItemRecycler(adapter, items);

        //int num_cats = category_data_types.size();

        //Toast.makeText(this, "hello" + num_cats, Toast.LENGTH_SHORT).show();

        add_item_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItem();
            }
        });


    }


 /*
    @Override
    public void onNoteClick(int position) {
      //  Log.d(TAG, "onNoteClick: " + position);




       // Intent intent = new Intent(this, RegisterPage.class);
       // intent.putExtra("category name", "something else");
       // startActivity(intent);
    }

   */


    void Back_Button () {

        Intent intent = new Intent(this, RecyclePage.class);

        startActivity(intent);

    }

    void AddItem () {

        Intent intent = new Intent(this, AddItemPage.class);

        intent.putExtra("category_index_data", category_index);


        startActivity(intent);



    }

    @Override
    public void row_click_reciever(int index) {


        //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();

       // Intent intent = new Intent(this, Item_Test.class);

        //intent.putExtra("name_data", category_data_types.get(index).category_name);

        //startActivity(intent);

    }




    void AddItemRecycler(ItemAdapter adapter, List<String> items) {


        //Toast.makeText(this, getIntent().getStringExtra("category_name_data") + getIntent().getIntExtra("category_max_items_data", 0) , Toast.LENGTH_SHORT).show();


        if (UserCategories.user_category_information.get(category_index).items == null) {

            Toast.makeText(this, "cat is null", Toast.LENGTH_LONG).show();



        }else  {

            Toast.makeText(this, "cat is not null", Toast.LENGTH_LONG).show();

            for (Item_Data_Type item : UserCategories.user_category_information.get(category_index).items) {

                // if (item.item_name == null) {

                // Toast.makeText(this, "fucked", Toast.LENGTH_SHORT).show();
                //}

                 items.add(item.item_name);

                //Toast.makeText(this, cat.category_name, Toast.LENGTH_SHORT).show();

                //category_data_types.add(cat);

                adapter.notifyItemInserted(items.size() + 1);


            }

        }




        //for (int i = 0; i < UserCategories.user_category_information.get(category_index).items.length; i++)
        //{





        //}




    }


}