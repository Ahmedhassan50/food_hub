package com.example.foodhub.ui.restaurantdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.databinding.ActivityRestaurantDetailsBinding;
import com.example.foodhub.ui.home.adapters.MealAdapter;
import com.example.foodhub.ui.restaurantdetails.adapters.FeaturedItemAdapter;
import com.example.foodhub.ui.restaurantdetails.adapters.MealTypesAdapter;

import java.util.ArrayList;

public class RestaurantDetailsActivity extends AppCompatActivity {

    private ActivityRestaurantDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String [] mealTypes ={"All","Legends","Bundles","AdditionalBundles"};
        FeaturedItemAdapter adapter =new FeaturedItemAdapter();
        MealTypesAdapter mealTypesAdapter =new MealTypesAdapter(mealTypes);

        binding.featuredItemsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.featuredItemsRv.setAdapter(adapter);

        binding.meatTypeRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.meatTypeRv.setAdapter(mealTypesAdapter);


        ArrayList<Meal> meals =new ArrayList<>();
        meals.add(new Meal(R.drawable.nuduls,4.5,5.50,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,8.25,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,5.50,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,8.25,25,"Salmon Salad"
                ,"Baked salmon fish"));
        MealAdapter mealAdapter =new MealAdapter(meals);

        binding.restaurantMealsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.restaurantMealsRv.setAdapter(mealAdapter);


        binding.backBtn.setOnClickListener(v->{
            finish();
        });



    }
}