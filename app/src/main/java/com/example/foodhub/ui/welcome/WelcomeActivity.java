package com.example.foodhub.ui.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityWelcomeBinding;
import com.example.foodhub.ui.auth.SignUpActivity;

public class WelcomeActivity extends BaseActivity {
    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();

        /*
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor( Color.TRANSPARENT);*/


        binding.createAccountBtn.setOnClickListener(v->{
            goTo(SignUpActivity.class);
        });

    }
}