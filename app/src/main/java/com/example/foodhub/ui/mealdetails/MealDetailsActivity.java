package com.example.foodhub.ui.mealdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.model.AddOn;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.databinding.ActivityMealDetailsBinding;
import com.example.foodhub.ui.category.CategoryViewModel;
import com.example.foodhub.ui.mealdetails.adapters.AddOnAdapter;

import java.util.ArrayList;

public class MealDetailsActivity extends AppCompatActivity {

    private ActivityMealDetailsBinding binding;
    private MealViewModel mealViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMealDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);

        String foodId = getIntent().getExtras().getString("food_id");

        ArrayList<AddOn> addOn =new ArrayList<>();
        addOn.add(new AddOn(R.drawable.add_on,"Pepper julienned"
                ,2.30));
        addOn.add(new AddOn(R.drawable.add_on,"Baby spinach"
                ,2.30));
        addOn.add(new AddOn(R.drawable.add_on,"Masroom"
                ,2.30));

        AddOnAdapter adapter =new AddOnAdapter(addOn);

        binding.addOnRv.setLayoutManager(new LinearLayoutManager(this));
        binding.addOnRv.setNestedScrollingEnabled(false);
        binding.addOnRv.setAdapter(adapter);

        binding.backBtn.setOnClickListener(v->{
            finish();
        });


        mealViewModel.getMealDetails(foodId);

        mealViewModel.mealDetails.observe(this, new Observer<Meal>() {
            @Override
            public void onChanged(Meal meal) {
                Glide.with(MealDetailsActivity.this).load(RetrofitModule.BASE_URL+meal.getImage()).into(binding.mealImage);
                binding.mealName.setText(meal.getName());
                binding.mealRate.setText(meal.getRate());
                binding.mealRateNumber.setText("("+meal.getRateNumber()+"+"+")");
                binding.mealPrice.setText("$"+meal.getPrice());
                binding.mealDescription.setText(meal.getDescription());


            }
        });





    }
}