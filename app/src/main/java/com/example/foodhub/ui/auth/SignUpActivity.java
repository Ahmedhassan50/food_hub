package com.example.foodhub.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.R;
import com.example.foodhub.data.remote.ServiceStatus;
import com.example.foodhub.databinding.ActivitySignUpBinding;
import com.example.foodhub.ui.home.HomeActivity;

public class SignUpActivity extends BaseActivity {

    private ActivitySignUpBinding binding;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/


        binding.signInBtn.setOnClickListener(v -> {
            goTo(LoginActivity.class);
        });

        binding.signUpBtn.setOnClickListener(view -> {
            String name = binding.signupNameEt.getText().toString();
            String email =binding.signupEmailEd.getText().toString();
            String password =binding.signupPasswordEd.getText().toString();
            String mobile =binding.signupMobileEd.getText().toString();

            if (signUpValidation(email,password,name,mobile)) {
                authViewModel.signUp(name,email,password,mobile);
            }
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
                    goTo(LoginActivity.class);
                }
            }
        });

    }


    private boolean signUpValidation(String email, String password, String name, String mobile) {
        boolean valid = true;
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            valid = false;
            binding.signupEmailLayout.setError("Please Enter Valid Email..");
        } else {
            binding.signupEmailLayout.setErrorEnabled(false);
        }

        if (password.isEmpty()) {
            valid = false;
            binding.signupPasswordLayout.setError("Please Enter Your Password..");

        } else {
            binding.signupPasswordLayout.setErrorEnabled(false);
        }

        if (name.isEmpty()) {
            valid = false;
            binding.signupNameLayout.setError("Please Enter Your Name..");

        } else {
            binding.signupNameLayout.setErrorEnabled(false);
        }

        if (mobile.isEmpty()) {
            valid = false;
            binding.signupMobileLayout.setError("Please Enter Your Mobile..");

        } else {
            binding.signupMobileLayout.setErrorEnabled(false);
        }
        return valid;
    }


    private void showProgress() {
        binding.signUpProgressBar.setVisibility(View.VISIBLE);
        binding.signUpBtn.setVisibility(View.INVISIBLE);
    }

    private void hideProgress() {
        binding.signUpProgressBar.setVisibility(View.GONE);
        binding.signUpBtn.setVisibility(View.VISIBLE);
    }


}