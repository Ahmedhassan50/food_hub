package com.example.foodhub.ui.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.R;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.databinding.FragmentFavoriteFoodItemBinding;
import com.example.foodhub.databinding.FragmentFavoriteRestaurantBinding;
import com.example.foodhub.ui.home.adapters.FavoriteRestaurantAdapter;
import com.example.foodhub.ui.home.adapters.MealAdapter;
import com.example.foodhub.ui.home.adapters.RestaurantAdapter;
import com.example.foodhub.ui.restaurantdetails.adapters.FeaturedItemAdapter;

import java.util.ArrayList;

public class FavoriteRestaurantFragment extends Fragment {
    private FragmentFavoriteRestaurantBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentFavoriteRestaurantBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Restaurant> restaurants =new ArrayList<>();
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.5,25,"McDonald’s",
                "free delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.7,99,"Starbuck",
                "$2 delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.5,25,"McDonald’s",
                "free delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.7,99,"Starbuck",
                "$2 delivery","10-15 mins"));
        FavoriteRestaurantAdapter restaurantAdapter =new FavoriteRestaurantAdapter(restaurants);
        binding.favoriteRestaurantRv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.favoriteRestaurantRv.setAdapter(restaurantAdapter);



    }
}
