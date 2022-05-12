package com.example.foodhub.ui.home.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.ui.restaurantdetails.RestaurantDetailsActivity;

import java.util.List;

public class FavoriteRestaurantAdapter extends  RecyclerView.Adapter<FavoriteRestaurantAdapter.FavoriteRestaurantViewHolder>{

    private List<Restaurant> restaurants;
    public FavoriteRestaurantAdapter(List<Restaurant>restaurants){
        this.restaurants=restaurants;
    }


    @NonNull
    @Override
    public FavoriteRestaurantAdapter.FavoriteRestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.favorite_restaurant_item,parent,false);
        return new FavoriteRestaurantAdapter.FavoriteRestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteRestaurantAdapter.FavoriteRestaurantViewHolder holder, int position) {
        Restaurant restaurant =restaurants.get(position);

        holder.restaurantName.setText(restaurant.getName());
        holder.restaurantImage.setImageResource(restaurant.getImage());
        holder.restaurantDelivery.setText(restaurant.getDelivery());
        holder.restaurantRate.setText(restaurant.getRate()+"");
        holder.restaurantDeliveryTime.setText(restaurant.getDeliveryTime());
        holder.restaurantRateNumber.setText("("+restaurant.getRateNumber()+")");


        holder.itemView.setOnClickListener(v->{
            Intent i =new Intent(holder.itemView.getContext(), RestaurantDetailsActivity.class);
            holder.itemView.getContext().startActivity(i);
        });


    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    static class FavoriteRestaurantViewHolder extends RecyclerView.ViewHolder{
        ImageView restaurantImage;
        TextView restaurantName;
        TextView restaurantRate;
        TextView restaurantRateNumber;
        TextView restaurantDelivery;
        TextView restaurantDeliveryTime;

        public FavoriteRestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImage = itemView.findViewById(R.id.restaurant_image);
            restaurantName= itemView.findViewById(R.id.restaurant_name);
            restaurantRate= itemView.findViewById(R.id.restaurant_rate);
            restaurantRateNumber= itemView.findViewById(R.id.restaurant_rate_number);
            restaurantDelivery= itemView.findViewById(R.id.restaurant_delivery);
            restaurantDeliveryTime= itemView.findViewById(R.id.restaurant_delivery_time);
        }
    }
}

