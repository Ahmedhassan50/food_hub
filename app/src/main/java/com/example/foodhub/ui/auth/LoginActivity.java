package com.example.foodhub.ui.auth;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.data.remote.ServiceStatus;
import com.example.foodhub.databinding.ActivityLoginBinding;
import com.example.foodhub.ui.home.HomeActivity;

import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding binding;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);


        binding.loginBackBtn.setOnClickListener(v -> {
            finish();
        });

        binding.signUpBtn.setOnClickListener(v -> {
            finish();
        });
        binding.forgotPassword.setOnClickListener(v -> {
            goTo(ResetPasswordActivity.class);
        });

        binding.loginBtn.setOnClickListener(v -> {
            String email = binding.signInEmailEd.getText().toString();
            String password = binding.signInPasswordEd.getText().toString();
            if (loginValidation(email, password)) {
                authViewModel.login(email, password);
            }

            //goTo(PhoneRegistrationActivity.class);
        });

        authViewModel.loginStatus.observe(this, new Observer<ServiceStatus>() {
            @Override
            public void onChanged(ServiceStatus serviceStatus) {
                if (serviceStatus == ServiceStatus.LOADING) {
                    showProgress();
                } else if (serviceStatus == ServiceStatus.ERROR) {
                    hideProgress();
                    showAlert ("Something went wrong. Please try again");

                } else if (serviceStatus == ServiceStatus.SUCCESS) {
                    hideProgress();
                    goTo(HomeActivity.class);
                }
            }
        });

    }

    private boolean loginValidation(String email, String password) {
        boolean valid = true;
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            valid = false;
            binding.signInEmailLayout.setError("Please Enter Valid Email..");
        } else {
            binding.signInEmailLayout.setErrorEnabled(false);
        }

        if (password.isEmpty()) {
            valid = false;
            binding.signInPasswordLayout.setError("Please Enter Your Password..");

        } else {
            binding.signInPasswordLayout.setErrorEnabled(false);
        }
        return valid;
    }


    private void showProgress() {
        binding.loginProgressBar.setVisibility(View.VISIBLE);
        binding.loginBtn.setVisibility(View.INVISIBLE);
    }

    private void hideProgress() {
        binding.loginProgressBar.setVisibility(View.GONE);
        binding.loginBtn.setVisibility(View.VISIBLE);
    }



}

