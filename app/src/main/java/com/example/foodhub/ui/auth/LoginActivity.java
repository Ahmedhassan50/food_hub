package com.example.foodhub.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();
        binding.loginBackBtn.setOnClickListener(v->{
            finish();
        });

        binding.signUpBtn.setOnClickListener(v->{
            finish();
        });
        binding.forgotPassword.setOnClickListener(v->{
            goTo(ResetPasswordActivity.class);
        });

    }





}