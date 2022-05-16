package com.example.foodhub.ui.search.adapter;

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
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.ui.mealdetails.MealDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private static final int FIRST_ELEMENT = 1;
    private static final int NORMAL_ELEMENT = 2;
    private List<Meal> meals = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return FIRST_ELEMENT;
        }
        return NORMAL_ELEMENT;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Meal>meals){
        this.meals=meals;
        notifyDataSetChanged();
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.food_search_item, parent, false);
        View firstV = inflater.inflate(R.layout.first_search_element, parent, false);

        if (viewType == FIRST_ELEMENT) {
            return new FirstElementSearchViewHolder(firstV);
        }
        return new RestaurantSearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Meal meal =meals.get(position);
        if (holder.getClass() == FirstElementSearchViewHolder.class) {
            FirstElementSearchViewHolder hold =(FirstElementSearchViewHolder) holder;

            hold.numOfSearchItem.setText( "Found\n"+(meals.size()-1)+" results");



        } else {

            RestaurantSearchViewHolder hold =(RestaurantSearchViewHolder) holder;
            Glide.with(hold.mealImage.getRootView()).load(RetrofitModule.BASE_URL+meal.getImage()).into(hold.mealImage);
            hold.mealName.setText(meal.getName());
            hold.restaurantName.setText("Baked salmon fish");
            hold.mealPrice.setText("$"+meal.getPrice()+"");
            hold.mealRate.setText(meal.getRate()+"");
            hold.mealRateNumber.setText("("+meal.getRateNumber()+"+"+")");

            hold.itemView.setOnClickListener(v->{
                Intent i =new Intent(hold.itemView.getContext(), MealDetailsActivity.class);
                i.putExtra("food_id",meal.getId());
                hold.itemView.getContext().startActivity(i);
            });

        }

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    static class RestaurantSearchViewHolder extends RecyclerView.ViewHolder {
        ImageView mealImage;
        TextView mealName;
        TextView restaurantName;
        TextView mealPrice;
        TextView mealRate;
        TextView mealRateNumber;


        public RestaurantSearchViewHolder(View itemView) {
            super(itemView);
            mealImage = itemView.findViewById(R.id.meal_image);
            restaurantName= itemView.findViewById(R.id.meal_restaurant);
            mealName= itemView.findViewById(R.id.meal_name);
            mealPrice= itemView.findViewById(R.id.meal_price);
            mealRate= itemView.findViewById(R.id.meal_rate);
            mealRateNumber= itemView.findViewById(R.id.meal_rate_number);

        }
    }

    static class FirstElementSearchViewHolder extends RecyclerView.ViewHolder {
        TextView numOfSearchItem ;

        public FirstElementSearchViewHolder(View itemView) {
            super(itemView);
            numOfSearchItem =itemView.findViewById(R.id.num_of_search_items);


        }
    }
}

