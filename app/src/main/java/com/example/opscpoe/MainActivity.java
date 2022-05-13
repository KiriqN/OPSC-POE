package com.example.opscpoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        MaterialButton register = (MaterialButton) findViewById(R.id.register);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegister();
            }
        });




        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                SharedPreferences credentials = getSharedPreferences("Credentials", MODE_PRIVATE);

                //String userDetails = credentials.getString(user + pass + "data", "Username or Password is incorrect");
//                SharedPreferences.Editor editor = credentials.edit();
//                editor.putString("display", userDetails);
//                editor.commit();

                Map<String, ?> users= credentials.getAll();
                if(users.get(user) != null) {
                    if(users.get(user).equals(pass)) {
                        OpenHome();
                    } {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Cannot find user", Toast.LENGTH_SHORT).show();
                }










            }
        });




    }




    public void OpenHome()
    {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void OpenRegister()
    {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }






}

