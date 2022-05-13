package com.example.opscpoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {


    private Button collections_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);





        collections_button = (Button) findViewById(R.id.go_collections_button);

        collections_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenCollections();
            }
        });

    }

    public void OpenCollections () {

        Intent intent = new Intent(this, Collections_page.class);
        startActivity(intent);

    }


}