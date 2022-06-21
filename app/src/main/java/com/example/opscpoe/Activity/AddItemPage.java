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

        UserCategories.user_category_information.get(cat_index).items = new List<Item_Data_Type>() {
            @Override
            public int size() {
                return UserCategories.user_category_information.get(cat_index).max_items;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Item_Data_Type> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Item_Data_Type item_data_type) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Item_Data_Type> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Item_Data_Type> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Item_Data_Type get(int i) {
                return null;
            }

            @Override
            public Item_Data_Type set(int i, Item_Data_Type item_data_type) {
                return null;
            }

            @Override
            public void add(int i, Item_Data_Type item_data_type) {

            }

            @Override
            public Item_Data_Type remove(int i) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Item_Data_Type> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Item_Data_Type> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Item_Data_Type> subList(int i, int i1) {
                return null;
            }
        };

        UserCategories.user_category_information.get(cat_index).items.add(new Item_Data_Type(null , item_name, 0 ,  UserCategories.user_category_information.get(cat_index), 0));

    }


    void Done () {

        SetData();

        Intent intent = new Intent(this, Item_Test.class);

        //intent.putExtra("item_name_data" , item_name);

        //startActivity(intent);

    }

    void Cancel () {

        Intent intent = new Intent(this, Item_Test.class);

        startActivity(intent);

    }
}