package com.example.opscpoe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opscpoe.R;

public class Item_Test extends AppCompatActivity {



    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_test);

        text = findViewById(R.id.textView);


        String name_data = getIntent().getStringExtra("name_data");

        text.setText(name_data);

        //Toast.makeText(this, name_data, Toast.LENGTH_LONG).show();

    }
}