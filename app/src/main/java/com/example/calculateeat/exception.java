package com.example.calculateeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color; //manually added

public class exception extends AppCompatActivity {
    private TextView errorText, messageText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);

        backButton = findViewById(R.id.backButton);

        Intent intent = getIntent();
        if (intent != null) {

            // Check if this is for a successful order or an error
            boolean isSuccessfulOrder = intent.getBooleanExtra("is_successful_order", false);

            errorText = findViewById(R.id.errorText);
            messageText = findViewById(R.id.messageText);

            if (isSuccessfulOrder) {
                // This is for a successful order
                errorText.setText("ORDER SUCCESSFUL");
                errorText.setTextColor(Color.parseColor("#32CD32")); // Green color
                messageText.setText("Thank you for your order!");
                messageText.setTextColor(Color.parseColor("#32CD32")); // Green color
            } else {
                // This is for an error
                errorText.setText("INPUT ERROR");
                errorText.setTextColor(Color.parseColor("#FA8072")); // Red color
                messageText.setText("Please check your input again");
                messageText.setTextColor(Color.parseColor("#FA8072")); // Red color
            }
        }


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
}