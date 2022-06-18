package com.example.opscpoe;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opscpoe.Activity.CategoryItemsActivity;
import com.example.opscpoe.Activity.RegisterPage;
import com.example.opscpoe.Models.Category;

import java.util.ArrayList;
import java.util.LinkedList;

public class Collections_page extends AppCompatActivity {

    // List<ItemData> items;
    int item_index_counter;
        Button add_button;
    GridView item_list;

    private ArrayList<Category> categoryList = new ArrayList<>();

    //CardView card_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections_page);

        add_button = findViewById(R.id.add_button);

        item_list = findViewById(R.id.category_grid_view);

//        items = new List<ItemData>() {
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean contains(@Nullable Object o) {
//                return false;
//            }
//
//            @NonNull
//            @Override
//            public Iterator<ItemData> iterator() {
//                return null;
//            }
//
//            @NonNull
//            @Override
//            public Object[] toArray() {
//                return new Object[0];
//            }
//
//            @NonNull
//            @Override
//            public <T> T[] toArray(@NonNull T[] ts) {
//                return null;
//            }
//
//            @Override
//            public boolean add(ItemData itemData) {
//                return false;
//            }
//
//            @Override
//            public boolean remove(@Nullable Object o) {
//                return false;
//            }
//
//            @Override
//            public boolean containsAll(@NonNull Collection<?> collection) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(@NonNull Collection<? extends ItemData> collection) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(int i, @NonNull Collection<? extends ItemData> collection) {
//                return false;
//            }
//
//            @Override
//            public boolean removeAll(@NonNull Collection<?> collection) {
//                return false;
//            }
//
//            @Override
//            public boolean retainAll(@NonNull Collection<?> collection) {
//                return false;
//            }
//
//            @Override
//            public void clear() {
//
//            }
//
//            @Override
//            public ItemData get(int i) {
//                return null;
//            }
//
//            @Override
//            public ItemData set(int i, ItemData itemData) {
//                return null;
//            }
//
//            @Override
//            public void add(int i, ItemData itemData) {
//
//            }
//
//            @Override
//            public ItemData remove(int i) {
//                return null;
//            }
//
//            @Override
//            public int indexOf(@Nullable Object o) {
//                return 0;
//            }
//
//            @Override
//            public int lastIndexOf(@Nullable Object o) {
//                return 0;
//            }
//
//            @NonNull
//            @Override
//            public ListIterator<ItemData> listIterator() {
//                return null;
//            }
//
//            @NonNull
//            @Override
//            public ListIterator<ItemData> listIterator(int i) {
//                return null;
//            }
//
//            @NonNull
//            @Override
//            public List<ItemData> subList(int i, int i1) {
//                return null;
//            }
//        };

//        ItemData[] item_data_array = new ItemData[] {
//                new ItemData(0, "item 1", R.drawable.google),
//                new ItemData(1, "item 2", R.drawable.google),
//                new ItemData(2, "item 3", R.drawable.google),
//
//        };

        // Create new category
        // Category category1 = new Category("Test Name", 6);

        // add category of category list
        // categoryList.add(category1);


        // create new item
        //ItemData item = new ItemData("", 0);

        // get the number of goals
        // category1.getGoalNumber();

        CategoryGridAdapter gd = new CategoryGridAdapter(this, categoryList);

        item_list.setAdapter(gd);

        item_list.setBackgroundColor(Color.WHITE);

        add_button.setOnClickListener(v -> {
            AddItemToList("Item name", 4);
            gd.notifyDataSetChanged();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        try{
            String categoryName = (String) getIntent().getStringExtra("name");
            ArrayList itemData = (ArrayList) getIntent().getSerializableExtra("items");

            for(int i = 0; i < categoryList.size(); i++) {
                if(categoryList.get(i).getName().equals(categoryName)) {
                    categoryList.get(i).updateItems(itemData);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void AddItemToList (String item_name, int goal) {

        Toast.makeText(Collections_page.this, "added item : " + item_index_counter, Toast.LENGTH_SHORT).show();

        int mockImage1 = getResources().getIdentifier("google.png", "drawable", getPackageName());
        ItemData mockItem1 = new ItemData("mock name", mockImage1);
        int mockImage2 = getResources().getIdentifier("google.png", "drawable", getPackageName());
        ItemData mockItem2= new ItemData("mock name", mockImage2);

        Category category1 = new Category(item_name, goal);
        category1.addItem(mockItem1);
        category1.addItem(mockItem2);

        categoryList.add(category1);

        // AddGridItem(categoryList.size(), item_name);

        item_index_counter++;
    }

//    void AddGridItem (int index, String name) {
//        Button button = new Button(this);
//        button.setText(name);
////        TextView textView = new TextView(this);
////        textView.setText(name + "   " + index);
//        item_list.addView(button);
//    }
}

 class CategoryGridAdapter extends BaseAdapter {
    private Context c;

    private ArrayList<Category> category_data;

    CategoryGridAdapter(Context c, ArrayList<Category> category_data)
    {
        this.c = c;
        this.category_data = category_data;
    }

    @Override
    public int getCount()
    {
        return category_data.size();
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
            view = inflater.inflate(R.layout.category_grid_layout, null);
        }
        Category category = category_data.get(i);

        ImageButton imageBtn = view.findViewById(R.id.category_image);
        TextView item_name = view.findViewById(R.id.category_title);
        item_name.setText(category.getName());

        imageBtn.setOnClickListener(v-> {
            System.out.println("Item clicked:  " + i);

            Intent intent = new Intent(c, CategoryItemsActivity.class);

            Bundle bundle = new Bundle();

            bundle.putString("name", category.getName());
            bundle.putInt("goal", category.getGoalNumber());
            bundle.putSerializable("items" ,category.getItems());

            intent.putExtras(bundle);
            c.startActivity(intent);

            //move to different page -> category_data.get(i)
        });

        return view;
    }



//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup)
//    {
//        if (view == null)
//        {
//            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.grid_layout, null);
//        }
//        ImageView imageView = view.findViewById(R.id.imageView);
//        imageView.setImageResource(items_data.get(i).item_image);
//        TextView item_name = view.findViewById(R.id.textView);
//        item_name.setText(items_data[i].item_name);
//
//        return view;
//    }
}


