package com.example.foodhub.ui.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.R;
import com.example.foodhub.data.model.Category;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.databinding.FragmentHomeBinding;
import com.example.foodhub.ui.home.adapters.CategoryAdapter;
import com.example.foodhub.ui.home.adapters.MealAdapter;
import com.example.foodhub.ui.home.adapters.RestaurantAdapter;
import com.example.foodhub.ui.mealdetails.MealDetailsActivity;
import com.example.foodhub.ui.search.SearchActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding =FragmentHomeBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Category> categories =new ArrayList<>();
        categories.add(new Category(R.drawable.burger_image,"Burger"));
        categories.add(new Category(R.drawable.burger_image,"Donat"));
        categories.add(new Category(R.drawable.burger_image,"Pizza"));
        categories.add(new Category(R.drawable.burger_image,"Mexican"));
        categories.add(new Category(R.drawable.burger_image,"Asian"));

        ArrayList<Restaurant> restaurants =new ArrayList<>();
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.5,25,"McDonald’s",
                "free delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.7,99,"Starbuck",
                "$2 delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.5,25,"McDonald’s",
                "free delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.7,99,"Starbuck",
                "$2 delivery","10-15 mins"));

        ArrayList<Meal> meals =new ArrayList<>();
        meals.add(new Meal(R.drawable.nuduls,4.5,5.50,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,8.25,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,5.50,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,8.25,25,"Salmon Salad"
                ,"Baked salmon fish"));



        CategoryAdapter adapter =new CategoryAdapter(categories);
        RestaurantAdapter restaurantAdapter =new RestaurantAdapter(restaurants);
        MealAdapter mealAdapter =new MealAdapter(meals);

        binding.categoryRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.categoryRv.setAdapter(adapter);

        binding.restaurantRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.restaurantRv.setAdapter(restaurantAdapter);

        binding.mealsRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.mealsRv.setAdapter(mealAdapter);


        binding.searchLayout.setOnClickListener(v->{
            Intent i =new Intent(getContext(), SearchActivity.class);
           getContext().startActivity(i);
        });



    }
}
