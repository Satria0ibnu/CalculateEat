package com.example.calculateeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private EditText name, grams, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submitButton);

        name = findViewById((R.id.nameEditText));
        grams = findViewById(R.id.quantityEditText);
        phone = findViewById(R.id.phoneEditText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name0 = "";
                int grams0 = 0;
                int phone0 = 0;

                try {
                    String text = grams.getText().toString();
                    grams0 = Integer.parseInt(text);
                    String text1 = phone.getText().toString();

                    // Get the name without any leading or trailing spaces
                    name0 = name.getText().toString().trim();


                    // If no exception occurs, launch the "Result" activity
                    Intent intent = new Intent(getApplicationContext(), Result.class);
                    intent.putExtra("name_key", name0);
                    intent.putExtra("grams_key", grams0);
                    intent.putExtra("phone_key", text1);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    // Handle the exception for invalid gram or phone input here
                    Intent intent = new Intent(getApplicationContext(), exception.class);
                    intent.putExtra("is_successful_order", false);
                    startActivity(intent);
                }
            }
        });



    }
}