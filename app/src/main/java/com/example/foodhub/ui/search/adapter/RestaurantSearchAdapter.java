package com.example.foodhub.ui.search.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.ui.home.adapters.CartAdapter;
import com.example.foodhub.ui.mealdetails.MealDetailsActivity;
import com.example.foodhub.ui.restaurantdetails.RestaurantDetailsActivity;

import java.util.ArrayList;
import java.util.List;


public class RestaurantSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int FIRST_ELEMENT = 1;
    private static final int NORMAL_ELEMENT = 2;
    private List<Restaurant> restaurants = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return FIRST_ELEMENT;
        }
        return NORMAL_ELEMENT;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.restaurant_search_item, parent, false);
        View firstV = inflater.inflate(R.layout.first_search_element, parent, false);

        if (viewType == FIRST_ELEMENT) {
            return new FirstElementSearchViewHolder(firstV);
        }
        return new RestaurantSearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Restaurant restaurant = restaurants.get(position);

        if (holder.getClass() == FirstElementSearchViewHolder.class) {
            FirstElementSearchViewHolder hold = (FirstElementSearchViewHolder) holder;
            hold.numOfSearchedItems.setText("Found\n" + (restaurants.size() - 1) + " results");
        } else {
            RestaurantSearchViewHolder hold = (RestaurantSearchViewHolder) holder;
            Glide.with(hold.searchedRestaurantImage.getRootView()).load(RetrofitModule.BASE_URL + restaurant.getImage()).into(hold.searchedRestaurantImage);

            hold.searchedRestaurantName.setText(restaurant.getName());
            hold.searchedRestaurantDelvery.setText(restaurant.getDelivery());
            hold.searchedRestaurantDelveryTime.setText(restaurant.getDeliveryTime());
            hold.searchedRestaurantRate.setText(restaurant.getRate());
            holder.itemView.setOnClickListener(v->{
                Intent i =new Intent(holder.itemView.getContext(), RestaurantDetailsActivity.class);
                i.putExtra("restaurant_id",restaurant.getId());
                holder.itemView.getContext().startActivity(i);
            });
        }

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    static class RestaurantSearchViewHolder extends RecyclerView.ViewHolder {

        ImageView searchedRestaurantImage;
        TextView searchedRestaurantName;
        TextView searchedRestaurantDelvery;
        TextView searchedRestaurantDelveryTime;
        TextView searchedRestaurantRate;


        public RestaurantSearchViewHolder(View itemView) {
            super(itemView);
            searchedRestaurantImage = itemView.findViewById(R.id.searched_restaurant_image);
            searchedRestaurantName = itemView.findViewById(R.id.restaurant_name);
            searchedRestaurantDelvery = itemView.findViewById(R.id.restaurant_delivery);
            searchedRestaurantDelveryTime = itemView.findViewById(R.id.restaurant_delivery_time);
            searchedRestaurantRate = itemView.findViewById(R.id.searched_restaurant_rate);


        }
    }

    static class FirstElementSearchViewHolder extends RecyclerView.ViewHolder {
        TextView numOfSearchedItems;

        public FirstElementSearchViewHolder(View itemView) {
            super(itemView);
            numOfSearchedItems = itemView.findViewById(R.id.num_of_search_items);

        }
    }
}
