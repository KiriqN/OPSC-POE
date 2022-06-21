package com.example.opscpoe.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.opscpoe.Collections_page;
import com.example.opscpoe.Graph;
import com.example.opscpoe.R;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HomePage extends AppCompatActivity {


    private Button collection_button;
    private Button completion_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        List<Item_Data_Type> items_cat1 = new List<Item_Data_Type>() {
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

        List<Item_Data_Type> items_cat2 = new List<Item_Data_Type>() {
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

        Category_Data_Type cat1 = new Category_Data_Type("cat1" , 5 , 0 , 5 , items_cat1);

        Category_Data_Type cat2 = new Category_Data_Type("cat2" , 5 , 0 , 5 , items_cat2);



        completion_button = (Button) findViewById(R.id.goals);
        collection_button = (Button) findViewById(R.id.go_collection_button);

        completion_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goals();
            }
        }));

        collection_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenCollections();
            }
        });

    }

    public void OpenCollections ()
    {

        Intent intent = new Intent(this, RecyclePage.class);
        startActivity(intent);

    }

    public void goals()
    {
        Intent intent = new Intent(this, Graph.class);
        startActivity(intent);
    }


}