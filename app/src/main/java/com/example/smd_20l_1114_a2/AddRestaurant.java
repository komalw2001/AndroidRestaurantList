package com.example.smd_20l_1114_a2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.Objects;

public class AddRestaurant extends AppCompatActivity {

    private TextInputEditText etARName;
    private TextInputEditText etARLocation;
    private TextInputEditText etARDesc;
    private TextInputEditText etARPhone;
    private TextInputEditText etARRating;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        init();
    }

    private void init() {
        etARName = findViewById(R.id.etARName);
        etARLocation = findViewById(R.id.etARLocation);
        etARDesc = findViewById(R.id.etARDesc);
        etARPhone = findViewById(R.id.etARPhone);
        etARRating = findViewById(R.id.etARRating);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Objects.requireNonNull(etARName.getText()).toString().trim();
                String location = Objects.requireNonNull(etARLocation.getText()).toString().trim();
                String description = Objects.requireNonNull(etARDesc.getText()).toString().trim();
                String phone = Objects.requireNonNull(etARPhone.getText()).toString().trim();
                String rating = Objects.requireNonNull(etARRating.getText()).toString().trim();

                if (name.isEmpty() || location.isEmpty() || description.isEmpty() || phone.isEmpty() || rating.isEmpty()) {
                    Toast.makeText(AddRestaurant.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (name.length() < 2) {
                    Toast.makeText(AddRestaurant.this, "Restaurant name should be at least 2 characters", Toast.LENGTH_SHORT).show();
                } else if (location.length() < 3) {
                    Toast.makeText(AddRestaurant.this, "Location should be at least 3 characters", Toast.LENGTH_SHORT).show();
                } else if (description.length() < 10) {
                    Toast.makeText(AddRestaurant.this, "Description should be at least 10 characters", Toast.LENGTH_SHORT).show();
                } else if (phone.length() < 10) {
                    Toast.makeText(AddRestaurant.this, "Phone number should be at least 10 digits", Toast.LENGTH_SHORT).show();
                } else if (!phone.matches("\\d+")) {
                    Toast.makeText(AddRestaurant.this, "Phone number should contain only digits", Toast.LENGTH_SHORT).show();
                } else if (!rating.matches("[1-5](\\.\\d+)?")) {
                    Toast.makeText(AddRestaurant.this, "Rating should be between 1 and 5", Toast.LENGTH_SHORT).show();
                } else {
                    double parsedRating = Double.parseDouble(rating);
                    if (parsedRating > 5.0) {
                        Toast.makeText(AddRestaurant.this, "Rating should be between 1 and 5", Toast.LENGTH_SHORT).show();
                    } else {
                        DecimalFormat df = new DecimalFormat("#.#"); // 1 decimal place
                        double roundedRating = Double.parseDouble(df.format(parsedRating));
                        Intent intent = new Intent();
                        intent.putExtra("name", name);
                        intent.putExtra("location", location);
                        intent.putExtra("description", description);
                        intent.putExtra("phone", phone);
                        intent.putExtra("rating", roundedRating);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            }
        });

    }
}
