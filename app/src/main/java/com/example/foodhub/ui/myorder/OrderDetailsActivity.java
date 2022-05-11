package com.example.foodhub.ui.myorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.databinding.ActivityOrdreDetailsBinding;

public class OrderDetailsActivity extends BaseActivity {
    private ActivityOrdreDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityOrdreDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backBtn.setOnClickListener(v->{
            finish();
        });


    }
}