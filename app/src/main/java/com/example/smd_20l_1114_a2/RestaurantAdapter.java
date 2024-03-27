package com.example.smd_20l_1114_a2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RViewHolder>
{
    ArrayList<Restaurant> restaurants;

    public RestaurantAdapter(ArrayList<Restaurant> rest){
        this.restaurants = rest;
    }

    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.restaurant_list_item, parent, false);
        return new RViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position) {
        holder.tvRestName.setText(restaurants.get(position).getName());
        holder.tvRestLocation.setText(restaurants.get(position).getLocation());
        holder.tvRestPhone.setText(restaurants.get(position).getPhone());
        holder.tvRestDesc.setText(restaurants.get(position).getDescription());
        holder.tvRating.setText(String.valueOf(restaurants.get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class RViewHolder extends RecyclerView.ViewHolder {

        TextView tvRestName, tvRestLocation, tvRestDesc, tvRestPhone, tvRating;

        public RViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRestName = itemView.findViewById(R.id.tvRestName);
            tvRestDesc = itemView.findViewById(R.id.tvRestDesc);
            tvRestLocation = itemView.findViewById(R.id.tvRestLocation);
            tvRestPhone = itemView.findViewById(R.id.tvRestPhone);
            tvRating = itemView.findViewById(R.id.tvRestRating);
        }
    }
}
