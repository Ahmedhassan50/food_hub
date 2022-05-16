package com.example.foodhub.ui.home.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.ui.mealdetails.MealDetailsActivity;
import com.example.foodhub.ui.restaurantdetails.RestaurantDetailsActivity;
import com.example.foodhub.ui.restaurantdetails.adapters.FeaturedItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFoodItemAdapter extends  RecyclerView.Adapter<FavoriteFoodItemAdapter.FavoriteFoodItemViewHolder>{



    private List<Meal> foodItems =new ArrayList<>();


    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Meal>foodItems){
        this.foodItems=foodItems;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FavoriteFoodItemAdapter.FavoriteFoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.favorite_food_item,parent,false);
        return new FavoriteFoodItemAdapter.FavoriteFoodItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteFoodItemAdapter.FavoriteFoodItemViewHolder holder, int position) {
        Meal meal = foodItems.get(position);

        Glide.with(holder.mealImage.getRootView()).load(RetrofitModule.BASE_URL+meal.getImage()).into(holder.mealImage);
        holder.mealName.setText(meal.getName());
        holder.mealRestaurant.setText("Baked salmon fish");
        holder.mealPrice.setText("$"+meal.getPrice()+"");
        holder.mealRate.setText(meal.getRate()+"");
        holder.mealRateNumber.setText("("+meal.getRateNumber()+"+"+")");

        holder.itemView.setOnClickListener(v->{
            Intent i =new Intent(holder.itemView.getContext(), MealDetailsActivity.class);
            i.putExtra("food_id",meal.getId());
            holder.itemView.getContext().startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    static class FavoriteFoodItemViewHolder extends RecyclerView.ViewHolder{
        ImageView mealImage;
        TextView mealPrice;
        TextView mealRate;
        TextView mealRateNumber;
        TextView mealName;
        TextView mealRestaurant;



        public FavoriteFoodItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mealImage = itemView.findViewById(R.id.meal_image);
            mealPrice = itemView.findViewById(R.id.meal_price);
            mealName = itemView.findViewById(R.id.meal_name);
            mealRateNumber = itemView.findViewById(R.id.meal_rate_number);
            mealRate = itemView.findViewById(R.id.meal_rate);
            mealRestaurant = itemView.findViewById(R.id.meal_restaurant);

        }
    }
}
