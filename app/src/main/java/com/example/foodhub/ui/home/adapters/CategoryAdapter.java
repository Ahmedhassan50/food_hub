package com.example.foodhub.ui.home.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.model.Category;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.ui.category.CategoryActivity;
import com.example.foodhub.ui.restaurantdetails.RestaurantDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

   private List<Category> categories =new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Category>categories){
        this.categories=categories;
        notifyDataSetChanged();
    }
    private int selectedPosition=0;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.category_item,parent,false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
       Category category =categories.get(position);

       holder.categoryName.setText(category.getName());

        Glide.with(holder.categoryImage.getRootView()).load(RetrofitModule.BASE_URL+category.getImage()).into(holder.categoryImage);



        if(position==selectedPosition){
            holder.itemView.setBackgroundResource(R.drawable.category_selected_bg);
            holder.categoryName.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            holder.itemView.setBackgroundResource(R.drawable.category_unselected_bg);
        holder.categoryName.setTextColor(Color.parseColor("#67666D"));
        }
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("NotifyDataSetChanged")
           @Override
           public void onClick(View view) {
               selectedPosition =holder.getAdapterPosition();
               notifyDataSetChanged();
               Intent i =new Intent(holder.itemView.getContext(), CategoryActivity.class);
               i.putExtra("cat_name",category.getName());
               i.putExtra("cat_id",(selectedPosition+1)+"");
               holder.itemView.getContext().startActivity(i);
           }
       });




    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder{
       ImageView categoryImage;
       TextView categoryName;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage =itemView.findViewById(R.id.category_image);
            categoryName =itemView.findViewById(R.id.category_name);
        }
    }
}
