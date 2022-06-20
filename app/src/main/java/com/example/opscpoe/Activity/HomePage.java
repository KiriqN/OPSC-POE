package com.example.opscpoe.Activity;

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

public class HomePage extends AppCompatActivity {


    private Button collection_button;
    private Button completion_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);




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