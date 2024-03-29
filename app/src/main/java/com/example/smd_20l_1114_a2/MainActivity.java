package com.example.smd_20l_1114_a2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button filter1, filter2, filter3, filter4, filter5, addRest;
    RecyclerView rvRest;
    ArrayList<Restaurant> list;
    ArrayList<Restaurant> filteredList;
    RestaurantAdapter adapter;

    Boolean selectedfilter1, selectedfilter2,selectedfilter3, selectedfilter4,selectedfilter5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        selectedfilter1 = false;
        selectedfilter2 = false;
        selectedfilter3 = false;
        selectedfilter4 = false;
        selectedfilter5 = false;

        filter1 = findViewById(R.id.btnFilter1);
        filter2 = findViewById(R.id.btnFilter2);
        filter3 = findViewById(R.id.btnFilter3);
        filter4 = findViewById(R.id.btnFilter4);
        filter5 = findViewById(R.id.btnFilter5);
        addRest = findViewById(R.id.btnAddRest);
        rvRest = findViewById(R.id.rvRest);

        list = new ArrayList<>();

        list.add(new Restaurant("Subway","Lahore","04212345678","Delicious subs available!",3.9));
        list.add(new Restaurant("Pizza Place","Lahore","04212345678","Best pizza place!",4.3));
        list.add(new Restaurant("Fried Chicken","Lahore","04212345678","Fried chicken and burgers!",2.6));
        list.add(new Restaurant("Bad Restaurant","Lahore","04212345678","Burgers at low prices!",1.2));

        adapter = new RestaurantAdapter(list);

        rvRest.setLayoutManager(new LinearLayoutManager(this));
        rvRest.setHasFixedSize(true);
        rvRest.setAdapter(adapter);

        addRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddRestaurant.class);
                startActivityForResult(intent,1);
                //finish();
            }
        });

        filter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedfilter1){
                    selectedfilter1 = true;
                    applyFilter();
                }
                else {
                    selectedfilter1 = false;
                    applyFilter();
                }
                adapter.setRestaurants(filteredList);
                adapter.notifyDataSetChanged();
            }
        });

        filter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedfilter2){
                    selectedfilter2 = true;
                    applyFilter();
                }
                else {
                    selectedfilter2 = false;
                    applyFilter();
                }
                adapter.setRestaurants(filteredList);
                adapter.notifyDataSetChanged();
            }
        });

        filter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedfilter3){
                    selectedfilter3 = true;
                    applyFilter();
                }
                else {
                    selectedfilter3 = false;
                    applyFilter();
                }
                adapter.setRestaurants(filteredList);
                adapter.notifyDataSetChanged();
            }
        });

        filter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedfilter4){
                    selectedfilter4 = true;
                    applyFilter();
                }
                else {
                    selectedfilter4 = false;
                    applyFilter();
                }
                adapter.setRestaurants(filteredList);
                adapter.notifyDataSetChanged();
            }
        });

        filter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedfilter5){
                    selectedfilter5 = true;
                    applyFilter();
                }
                else {
                    selectedfilter5 = false;
                    applyFilter();
                }
                adapter.setRestaurants(filteredList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void applyFilter(){

        filter1.setBackgroundColor(selectedfilter1 ? ContextCompat.getColor(this, R.color.rating_btn_selected) : ContextCompat.getColor(this, R.color.rating_btn));
        filter2.setBackgroundColor(selectedfilter2 ? ContextCompat.getColor(this, R.color.rating_btn_selected) : ContextCompat.getColor(this, R.color.rating_btn));
        filter3.setBackgroundColor(selectedfilter3 ? ContextCompat.getColor(this, R.color.rating_btn_selected) : ContextCompat.getColor(this, R.color.rating_btn));
        filter4.setBackgroundColor(selectedfilter4 ? ContextCompat.getColor(this, R.color.rating_btn_selected) : ContextCompat.getColor(this, R.color.rating_btn));
        filter5.setBackgroundColor(selectedfilter5 ? ContextCompat.getColor(this, R.color.rating_btn_selected) : ContextCompat.getColor(this, R.color.rating_btn));

        if (!selectedfilter1 && !selectedfilter2 && !selectedfilter3 && !selectedfilter4 && !selectedfilter5)
        {
            filteredList = list;
            return;
        }

        filteredList = new ArrayList<>();

        for (Restaurant restaurant : list) {
            double rating = restaurant.getRating();
            if (selectedfilter1 && rating < 2 && rating >= 1)
                filteredList.add(restaurant);
            else if (selectedfilter2 && rating < 3 && rating >= 2)
                filteredList.add(restaurant);
            else if (selectedfilter3 && rating < 4 && rating >= 3)
                filteredList.add(restaurant);
            else if (selectedfilter4 && rating < 5 && rating >= 4)
                filteredList.add(restaurant);
            else if (selectedfilter5 && rating == 5)
                filteredList.add(restaurant);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode == RESULT_OK && data != null) {

            String newName = data.getStringExtra("name");
            String newLoc = data.getStringExtra("location");
            String newDesc = data.getStringExtra("description");
            String newPhone = data.getStringExtra("phone");
            Double newRating = data.getDoubleExtra("rating", 0.0);

            if (newName != null) {
                Restaurant newRestaurant = new Restaurant(newName,newLoc,newPhone,newDesc,newRating);
                list.add(newRestaurant);
                adapter.notifyDataSetChanged();
            }

        }
    }
}