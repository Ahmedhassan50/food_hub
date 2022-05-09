package com.example.foodhub.ui.restaurantdetails.adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodhub.R;
import com.example.foodhub.data.model.Category;

import java.util.List;

public class MealTypesAdapter extends  RecyclerView.Adapter<MealTypesAdapter.MealTypesViewHolder>{

    private String[] mealTypes;
    public MealTypesAdapter(String[]mealTypes){
        this.mealTypes=mealTypes;
    }
    private int selectedPosition=0;

    @NonNull
    @Override
    public MealTypesAdapter.MealTypesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.mea_type_item,parent,false);
        return new MealTypesAdapter.MealTypesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MealTypesAdapter.MealTypesViewHolder holder, int position) {
        String mealType =mealTypes[position];




        if(position==selectedPosition){
            holder.itemView.setBackgroundResource(R.drawable.auth_btn_bg);
            holder.mealType.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            holder.itemView.setBackgroundResource(R.drawable.meal_type_unselected_shpe);
            holder.mealType.setTextColor(Color.parseColor("#5B5B5E"));
        }
        holder.mealType.setText(mealType);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                selectedPosition =holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });




    }

    @Override
    public int getItemCount() {
        return mealTypes.length;
    }

    static class MealTypesViewHolder extends RecyclerView.ViewHolder{

        TextView mealType;
        public MealTypesViewHolder(@NonNull View itemView) {
            super(itemView);
            mealType =itemView.findViewById(R.id.meal_type);

        }
    }
}

