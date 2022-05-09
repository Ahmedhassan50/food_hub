package com.example.foodhub.ui.restaurantdetails.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;

public class FeaturedItemAdapter extends  RecyclerView.Adapter<FeaturedItemAdapter.FeaturedItemViewHolder>{

    @NonNull
    @Override
    public FeaturedItemAdapter.FeaturedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.featured_item,parent,false);
        return new FeaturedItemAdapter.FeaturedItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedItemAdapter.FeaturedItemViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class FeaturedItemViewHolder extends RecyclerView.ViewHolder{

        public FeaturedItemViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
