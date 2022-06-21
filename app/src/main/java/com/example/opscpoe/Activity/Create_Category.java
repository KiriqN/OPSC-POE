package com.example.opscpoe.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.opscpoe.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Create_Category extends AppCompatActivity {

    String category_name;

    int max_items;

    Button done_button;

    Button cancel_button;

    EditText name_input_field;

    EditText max_items_input_field;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);

        done_button = findViewById(R.id.cat_creation_done_button);

        cancel_button = findViewById(R.id.cat_creation_cancel_button);

        name_input_field = findViewById(R.id.cat_name_input_field);

        max_items_input_field = findViewById(R.id.cat_max_items_input_field);

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Done_Button();
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cancel_Button();
            }
        });



    }

    void SetData () {

       category_name = name_input_field.getText().toString();

       Integer max_items_parse = Integer.parseInt(max_items_input_field.getText().toString());

       max_items = max_items_parse;


    }


    void Done_Button () {

        SetData();

        Intent intent = new Intent(this, RecyclePage.class);

        //Toast.makeText(this, category_name + max_items, Toast.LENGTH_SHORT).show();

        intent.putExtra("category_name_data" , category_name);

        intent.putExtra("category_max_items_data", max_items);



        UserCategories.user_category_information.add(new Category_Data_Type(category_name, max_items, 0, 0, new ArrayList<Item_Data_Type>()));


        startActivity(intent);

    }

    void Cancel_Button () {

        Intent intent = new Intent(this , RecyclePage.class);

        startActivity(intent);


    }





}