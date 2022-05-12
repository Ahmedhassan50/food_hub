package com.example.foodhub.ui.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.ui.restaurantdetails.adapters.FeaturedItemAdapter;

public class FavoriteFoodItemAdapter extends  RecyclerView.Adapter<FavoriteFoodItemAdapter.FavoriteFoodItemViewHolder>{

    @NonNull
    @Override
    public FavoriteFoodItemAdapter.FavoriteFoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.favorite_food_item,parent,false);
        return new FavoriteFoodItemAdapter.FavoriteFoodItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteFoodItemAdapter.FavoriteFoodItemViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class FavoriteFoodItemViewHolder extends RecyclerView.ViewHolder{

        public FavoriteFoodItemViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
