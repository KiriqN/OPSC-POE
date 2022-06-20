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
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.opscpoe.R;
import com.google.android.material.button.MaterialButton;

import java.util.Map;

public class RecyclePage extends AppCompatActivity implements recycler_view_interface {

    String []data = {""};
    int counter = 0;
   public ProgressBar progressBar;



    ArrayList<Category_Data_Type> category_data_types = new ArrayList<>();

    public static final String TAG = "yay I'm clicked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_page);

        List<String> items = new LinkedList<>();
       // items.add("My Category 1");


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DemoAdapter adapter = new DemoAdapter(items, this);
        recyclerView.setAdapter(adapter);

        Button btn = findViewById(R.id.Add);

        EditText editText= (EditText)findViewById(R.id.et_item);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        

        findViewById(R.id.Add).setOnClickListener(view -> {
         //   items.add(data[counter%3]);
        //    counter++;
         //   items.add("Code it 2");
           // Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();"
            items.add(editText.getText().toString());

            category_data_types.add(new Category_Data_Type(editText.getText().toString() , 0, 0, 0, null));





            adapter.notifyItemInserted(items.size()+1);
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


    @Override
    public void row_click_reciever(int index) {

        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Item_Test.class);

        intent.putExtra("name_data", category_data_types.get(index).category_name);

        startActivity(intent);

    }
}