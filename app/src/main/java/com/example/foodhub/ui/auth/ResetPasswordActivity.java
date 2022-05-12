package com.example.foodhub.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityResetPasswordBinding;

public class ResetPasswordActivity extends BaseActivity {
    private ActivityResetPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();

        binding.resetBackBtn.setOnClickListener(v->{
            finish();
        });

        binding.resetPassword.setOnClickListener(view -> {

        });
    }
}