package com.example.foodhub.ui.restaurantdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.model.RestaurantDetails;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.databinding.ActivityRestaurantDetailsBinding;
import com.example.foodhub.ui.home.adapters.MealAdapter;
import com.example.foodhub.ui.mealdetails.MealDetailsActivity;
import com.example.foodhub.ui.mealdetails.MealViewModel;
import com.example.foodhub.ui.restaurantdetails.adapters.FeaturedItemAdapter;
import com.example.foodhub.ui.restaurantdetails.adapters.MealTypesAdapter;

import java.util.ArrayList;

public class RestaurantDetailsActivity extends AppCompatActivity {

    private ActivityRestaurantDetailsBinding binding;
    private RestaurantViewModel restaurantViewModel;
    private FeaturedItemAdapter featuredItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String restaurantId = getIntent().getExtras().getString("restaurant_id");
        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        String[] mealTypes = {"All", "Legends", "Bundles", "AdditionalBundles"};
        featuredItemAdapter = new FeaturedItemAdapter();
        MealTypesAdapter mealTypesAdapter = new MealTypesAdapter(mealTypes);

        binding.featuredItemsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.featuredItemsRv.setAdapter(featuredItemAdapter);

        binding.meatTypeRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.meatTypeRv.setAdapter(mealTypesAdapter);


        binding.restaurantMealsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        binding.restaurantMealsRv.setAdapter(mealAdapter);


        binding.backBtn.setOnClickListener(v -> {
            finish();
        });


        restaurantViewModel.getRestaurantDetails(restaurantId);


        restaurantViewModel.restaurantDetails.observe(this, new Observer<RestaurantDetails>() {
            @Override
            public void onChanged(RestaurantDetails restaurantDetails) {

                Glide.with(RestaurantDetailsActivity.this).load(RetrofitModule.BASE_URL + restaurantDetails.getRestaurant().getCover()).into(binding.restaurantCover);
                Glide.with(RestaurantDetailsActivity.this).load(RetrofitModule.BASE_URL + restaurantDetails.getRestaurant().getImage()).into(binding.restaurantImage);
                binding.restaurantName.setText(restaurantDetails.getRestaurant().getName());
                binding.restaurantAddress.setText(restaurantDetails.getRestaurant().getAddress());
                binding.restaurantDelivery.setText(restaurantDetails.getRestaurant().getDelivery());
                binding.restaurantDeliveryTime.setText(restaurantDetails.getRestaurant().getDeliveryTime());
                binding.restaurantRate.setText(restaurantDetails.getRestaurant().getRate());
                binding.restaurantRateNumber.setText("(" + restaurantDetails.getRestaurant().getRateNumber() + "+" + ")");


                featuredItemAdapter.setData(restaurantDetails.getMeals());

                binding.numOfItems.setText(restaurantDetails.getMeals().size() + "");


            }
        });


    }
}