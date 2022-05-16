package com.example.foodhub.ui.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodhub.data.model.Meal;
import com.example.foodhub.databinding.ActivityCategoryBinding;
import com.example.foodhub.databinding.ActivityLoginBinding;
import com.example.foodhub.ui.auth.AuthViewModel;
import com.example.foodhub.ui.home.adapters.FavoriteFoodItemAdapter;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {


    private ActivityCategoryBinding binding;
    private CategoryViewModel categoryViewModel;
    private FavoriteFoodItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        String catName = getIntent().getExtras().getString("cat_name");
        String catID = getIntent().getExtras().getString("cat_id");
        adapter = new FavoriteFoodItemAdapter();

        binding.catName.setText(catName);


        binding.backBtn.setOnClickListener(v -> {
            finish();
        });

        categoryViewModel.getCategoryMeals(catID);

        categoryViewModel.catMeals.observe(this, new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                adapter.setData(meals);
            }
        });


        binding.categoryFoodRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoryFoodRv.setAdapter(adapter);


    }
}