package com.example.opscpoe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Collections_page extends AppCompatActivity {


    List<ItemData> items;
    int item_index_counter;


    Button add_button;
    GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections_page);

        add_button = findViewById(R.id.add_button);

        grid = (GridLayout) findViewById(R.id.item_grid_layout);

        items = new List<ItemData>() {
            @Override
            public int size() {
                return 0;
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
            public Iterator<ItemData> iterator() {
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
            public boolean add(ItemData itemData) {
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
            public boolean addAll(@NonNull Collection<? extends ItemData> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends ItemData> collection) {
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
            public ItemData get(int i) {
                return null;
            }

            @Override
            public ItemData set(int i, ItemData itemData) {
                return null;
            }

            @Override
            public void add(int i, ItemData itemData) {

            }

            @Override
            public ItemData remove(int i) {
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
            public ListIterator<ItemData> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<ItemData> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<ItemData> subList(int i, int i1) {
                return null;
            }
        };




        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemToList("item : " + item_index_counter);
            }
        });

    }


    void AddItemToList (String item_name) {

        Toast.makeText(Collections_page.this, "added item : " + item_index_counter, Toast.LENGTH_SHORT).show();



        CreateButton(item_name);

        item_index_counter++;

    }


    void CreateButton (String item_name) {

        Button item_button = new Button(this);
        item_button.setText(item_name);

        item_button.setLayoutParams(new android.widget.GridLayout.LayoutParams());


        grid.addView(item_button);





        items.add(new ItemData(item_index_counter, item_name));


    }




}