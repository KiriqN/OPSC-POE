package com.example.opscpoe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.opscpoe.Collections_page;
import com.example.opscpoe.R;

public class HomePage extends AppCompatActivity {


    private Button collection_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);





        collection_button = (Button) findViewById(R.id.go_collection_button);

        collection_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenCollections();
            }
        });

    }

    public void OpenCollections () {

        Intent intent = new Intent(this, RecyclePage.class);
        startActivity(intent);

    }


}