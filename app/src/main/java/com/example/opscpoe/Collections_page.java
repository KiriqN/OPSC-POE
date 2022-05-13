package com.example.opscpoe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Collections_page extends AppCompatActivity {


    List<ItemData> items;
    int item_index_counter;


    Button add_button;
    GridView item_list;



    //CardView card_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections_page);

        add_button = findViewById(R.id.add_button);

        item_list = findViewById(R.id.grid_view_item);

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

        int[] itemsarray = new int[]{
                R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google
        };



        grid_adapter gd = new grid_adapter(this, itemsarray);


        item_list.setAdapter(gd);


        item_list.setBackgroundColor(Color.WHITE);



        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemToList("item : " + item_index_counter);
            }
        });

    }


    void AddItemToList (String item_name) {

        Toast.makeText(Collections_page.this, "added item : " + item_index_counter, Toast.LENGTH_SHORT).show();

        //AddGridItem(item_name);

        item_index_counter++;

    }

    void AddGridItem (String name) {

        //Button button = new Button(this);

        //button.setText(name);

        //item_list.addView(button);



    }


}



 class grid_adapter extends BaseAdapter {
    Context c;
    int items[];

    grid_adapter(Context c, int arr[])
    {
        this.c = c;
        items = arr;
    }

    @Override
    public int getCount()
    {
        return items.length;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_layout, null);
        }
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(items[i]);
        return view;
    }
}


