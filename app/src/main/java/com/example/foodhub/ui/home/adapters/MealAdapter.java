package com.example.foodhub.ui.home.adapters;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.model.Category;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.ui.mealdetails.MealDetailsActivity;
import com.example.foodhub.ui.restaurantdetails.RestaurantDetailsActivity;


import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class MealAdapter extends  RecyclerView.Adapter<MealAdapter.MealViewHolder>{

    private List<Meal> meals = new ArrayList<>();;


    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Meal>meals){
        this.meals=meals;
        notifyDataSetChanged();
    }



    @Override
    public MealAdapter.MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.meal_item,parent,false);
        return new MealAdapter.MealViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MealAdapter.MealViewHolder holder, int position) {
        Meal meal =meals.get(position);

        Glide.with(holder.mealImage.getRootView()).load(RetrofitModule.BASE_URL+meal.getImage()).into(holder.mealImage);
        holder.mealName.setText(meal.getName());
        holder.restaurantName.setText("Baked salmon fish");
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
        return meals.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder{
        ImageView mealImage;
        TextView mealName;
        TextView restaurantName;
        TextView mealPrice;
        TextView mealRate;
        TextView mealRateNumber;


        public MealViewHolder(View itemView) {
            super(itemView);
             mealImage = itemView.findViewById(R.id.meal_image);
             restaurantName= itemView.findViewById(R.id.meal_restaurant);
             mealName= itemView.findViewById(R.id.meal_name);
             mealPrice= itemView.findViewById(R.id.meal_price);
             mealRate= itemView.findViewById(R.id.meal_rate);
             mealRateNumber= itemView.findViewById(R.id.meal_rate_number);
        }
    }
}
