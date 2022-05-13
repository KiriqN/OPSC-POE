package com.example.opscpoe;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class add_item_page extends AppCompatActivity {

    Button add_item_button;

    Button done_button;

    ImageView display_image;

    TextView item_text;

    ItemData created_item;

    Uri selected_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_page);

        add_item_button = (Button) findViewById(R.id.add_item_button);

        done_button = (Button) findViewById(R.id.done_button);

        display_image = findViewById(R.id.display_item_image);

        item_text = findViewById(R.id.item_name_text);



        add_item_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, 3);


            }
        });

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StoreItemData(selected_image, item_text.getText().toString());


            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK && data != null) {

            selected_image = data.getData();

            display_image.setImageURI(selected_image);



        }


    }


    void StoreItemData (Uri image, String name) {

        created_item = new ItemData(name, image);



    }
}