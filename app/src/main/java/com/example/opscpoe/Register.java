package com.example.opscpoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class Register extends AppCompatActivity {

    private EditText registerUser;
    private EditText registerPassword;
    private SharedPreferences credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        credentials = getSharedPreferences("Credentials", MODE_PRIVATE);

        registerUser = findViewById(R.id.registerUser);
        registerPassword = findViewById(R.id.registerPassword);

        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.registerbtn);




        registerbtn.setOnClickListener(v -> {
            checkDataEntered();
            String newUser = registerUser.getText().toString();
            String newPassword = registerPassword.getText().toString();

            SharedPreferences.Editor editor = credentials.edit();

            editor.putString(newUser, newPassword);
            Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            editor.commit();

            sendLogin();
        });

    }

    void sendLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);

    }

    void checkDataEntered() {
        if (isEmpty((registerUser))) {
            Toast t = Toast.makeText(this, "You must enter a username!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty((registerPassword))) {
            Toast t = Toast.makeText(this, "You must enter a Password!", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}



