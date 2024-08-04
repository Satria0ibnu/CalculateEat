package com.example.calculateeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat; //added manually
import java.util.Locale; //added manually


public class Result extends AppCompatActivity {

    private TextView name, phoneText1, quantity, price;
    private int priceResult;
    private Button orderButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Retrieve the Intent that started this activity
        Intent intent = getIntent();

        // Retrieve the values from the Intent using the keys you used when you put them
        String names = intent.getStringExtra("name_key");
        int grams = intent.getIntExtra("grams_key", 0); // 0 is the default value if the key is not found
        String phone = intent.getStringExtra("phone_key"); // 0 is the default value if the key is not found

        // Now you can use these values in your ResultActivity
        orderButton = findViewById(R.id.orderButton);
        backButton = findViewById(R.id.backButton);
        name = findViewById(R.id.nameText);
        phoneText1 = findViewById(R.id.phoneText);
        quantity = findViewById(R.id.quantityText);
        price = findViewById(R.id.priceText);


        priceResult = grams * 75;

        // Create a Locale for Indonesia
        Locale indonesiaLocale = new Locale("id", "ID");
        // Create a NumberFormat instance for currency formatting
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(indonesiaLocale);
        // Format your integer value as IDR
        String formattedValue = currencyFormat.format(priceResult);


        // Display the values in TextViews or perform any other operations
        name.setText(names);
        phoneText1.setText(phone);
        quantity.setText(String.valueOf(grams) + " grams");
        price.setText(String.valueOf(formattedValue));

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), exception.class);
                intent.putExtra("is_successful_order", true);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
