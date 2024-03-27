package com.example.smd_20l_1114_a2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button filter1, filter2, filter3, filter4, filter5, addRest;
    RecyclerView rvRest;
    ArrayList<Restaurant> list;
    RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        filter1 = findViewById(R.id.btnFilter1);
        filter2 = findViewById(R.id.btnFilter2);
        filter3 = findViewById(R.id.btnFilter3);
        filter4 = findViewById(R.id.btnFilter4);
        filter5 = findViewById(R.id.btnFilter5);
        addRest = findViewById(R.id.btnAddRest);
        rvRest = findViewById(R.id.rvRest);

        list = new ArrayList<>();

        list.add(new Restaurant("Subway","Lahore","04212345678","Delicious subs available!",3.9));
        list.add(new Restaurant("Dominos","Lahore","04212345678","Best pizza place!",4.3));
        list.add(new Restaurant("KFC","Lahore","04212345678","Fried chicken and burgers!",4.6));
        list.add(new Restaurant("Bad Restaurant","Lahore","04212345678","Burgers at low prices!",1.7));

        adapter = new RestaurantAdapter(list);

        rvRest.setLayoutManager(new LinearLayoutManager(this));
        rvRest.setHasFixedSize(true);
        rvRest.setAdapter(adapter);
    }
}