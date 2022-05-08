package com.example.foodhub.ui.home.adapters;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodhub.R;
import com.example.foodhub.data.model.Meal;


import java.util.List;

public class MealAdapter extends  RecyclerView.Adapter<MealAdapter.MealViewHolder>{

    private List<Meal> meals;
    public MealAdapter(List<Meal>meals){
        this.meals=meals;
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


        holder.mealImage.setImageResource(meal.getImage());
        holder.mealName.setText(meal.getName());
        holder.restaurantName.setText(meal.getRestaurantName());
        holder.mealPrice.setText("$"+meal.getPrice()+"");
        holder.mealRate.setText(meal.getRate()+"");
        holder.mealRateNumber.setText("("+meal.getRateNumber()+")");


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
