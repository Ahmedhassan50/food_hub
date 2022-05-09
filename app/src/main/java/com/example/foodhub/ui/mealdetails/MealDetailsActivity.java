package com.example.foodhub.ui.mealdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.data.model.AddOn;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.databinding.ActivityMealDetailsBinding;
import com.example.foodhub.ui.mealdetails.adapters.AddOnAdapter;

import java.util.ArrayList;

public class MealDetailsActivity extends AppCompatActivity {

    private ActivityMealDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMealDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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





    }
}