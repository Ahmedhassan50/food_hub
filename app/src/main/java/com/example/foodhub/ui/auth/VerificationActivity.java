package com.example.foodhub.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityVerificationBinding;

public class VerificationActivity extends BaseActivity {

    private ActivityVerificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();


        binding.verifiyBackBtn.setOnClickListener(v->{
            finish();
        });
    }
}