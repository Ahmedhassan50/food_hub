package com.example.foodhub.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.databinding.ActivityOrdreDetailsBinding;
import com.example.foodhub.databinding.ActivityProfileBinding;

public class ProfileActivity extends BaseActivity {
    private ActivityProfileBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();


        binding.backBtn.setOnClickListener(v->{
            finish();
        });


    }

}