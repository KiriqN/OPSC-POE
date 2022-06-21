package com.example.opscpoe.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.opscpoe.R;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AddItemPage extends AppCompatActivity {


    String item_name;

    int cat_index;

    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_page2);


        cat_index = getIntent().getIntExtra("category_index_data", 0);

        editText = findViewById(R.id.item_name_input_field);

        Button done_button = findViewById(R.id.item_done_button);

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Done();
            }
        });

        Button cancel_button = findViewById(R.id.item_cancel_button);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cancel();
            }
        });


       // SetData();



    }

    void SetData () {

        item_name = editText.getText().toString();




        UserCategories.user_category_information.get(cat_index).items.add(new Item_Data_Type(null , item_name, 0 ,  UserCategories.user_category_information.get(cat_index), 0));

        UserCategories.user_category_information.get(cat_index).current_items++;

    }


    void Done () {

        SetData();

        Intent intent = new Intent(this, Item_Test.class);

        intent.putExtra("item_name_data" , item_name);

        startActivity(intent);

    }

    void Cancel () {

        Intent intent = new Intent(this, Item_Test.class);

        startActivity(intent);

    }
}